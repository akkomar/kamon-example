name := "kamon-example"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "io.kamon" %% "kamon-core" % "0.4.0",
  "io.kamon" %% "kamon-log-reporter" % "0.4.0",
  "io.kamon" %% "kamon-statsd" % "0.4.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "ch.qos.logback" %  "logback-classic" % "1.1.2"
)
    