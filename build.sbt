name := "kamon-example"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4-M1",
  "io.kamon" %% "kamon-core" % "0.4.0",
  "io.kamon" %% "kamon-statsd" % "0.4.0"
)
    