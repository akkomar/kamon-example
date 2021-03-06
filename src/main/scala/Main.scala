import java.util.concurrent._

import akka.actor.{Props, ActorSystem}
import com.typesafe.scalalogging.LazyLogging
import kamon.Kamon
import kamon.trace.Tracer

import scala.concurrent.duration.Duration

object Main extends App with LazyLogging {
  Kamon.start()

  val r = scala.util.Random

  val someHistogram = Kamon.metrics.histogram("some-histogram")
  val someCounter = Kamon.metrics.counter("some-counter")

  someHistogram.record(42)
  someHistogram.record(50)
  someCounter.increment()


  val actorSystem = ActorSystem()

  val tracePrinter = actorSystem.actorOf(Props[TracePrinter])
  Kamon.tracer.subscribe(tracePrinter)

  val scheduler = actorSystem.scheduler
  val bigTask = new Runnable {
    def run() {
      someCounter.increment()
      Tracer.withNewContext("bigTask-trace", autoFinish = true) {
        Tracer.currentContext.withNewSegment("first-segment", "segment-category", "segment-library") {
          Thread.sleep(r.nextInt(100))
          logger.info("First step")
        }

        //task not included in segment:
//        Thread.sleep(r.nextInt(300))

        Tracer.currentContext.withNewSegment("second-segment", "segment-category", "segment-library") {
          Thread.sleep(r.nextInt(300))
          logger.info("Second step")
        }

//        Tracer.currentContext.withNewSegment("first-segment", "segment-category", "segment-library") {
//          Thread.sleep(r.nextInt(100))
//          logger.info("First step again")
//        }

        Tracer.currentContext.withNewSegment("third-segment", "segment-category", "segment-library") {
          Thread.sleep(r.nextInt(50))
          logger.info("Final step")
        }
      }

    }
  }

  implicit val executor = actorSystem.dispatcher

  scheduler.schedule(
    initialDelay = Duration(0, TimeUnit.SECONDS),
    interval = Duration(50, TimeUnit.MILLISECONDS),
    runnable = bigTask)

  Thread.sleep(50000)
  actorSystem.shutdown()
  Kamon.shutdown()
}
