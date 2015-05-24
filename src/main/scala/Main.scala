import java.util
import java.util.concurrent._

import kamon.Kamon

object Main extends App {
  Kamon.start()

  val someHistogram = Kamon.metrics.histogram("some-histogram")
  val someCounter = Kamon.metrics.counter("some-counter")

  someHistogram.record(42)
  someHistogram.record(50)
  someCounter.increment()

  // This application wont terminate unless you shutdown Kamon.
  Kamon.shutdown()

}
