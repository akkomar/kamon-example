import akka.actor.Actor
import kamon.trace.TraceInfo

class TracePrinter extends Actor {
  def receive = {
    case traceInfo: TraceInfo =>

      println("#################################################")
      println("Trace Name: " + traceInfo.name)
      println("Timestamp: " + traceInfo.timestamp)
      println("Elapsed Time: " + traceInfo.elapsedTime)
      println("Segments: ")

      traceInfo.segments.foreach { segmentInfo =>
        println("    ------------------------------------------")
        println("    Name: " + segmentInfo.name)
        println("    Category: " + segmentInfo.category)
        println("    Library: " + segmentInfo.library)
        println("    Timestamp: " + segmentInfo.timestamp)
        println("    Elapsed Time: " + segmentInfo.elapsedTime)
      }
  }
}