import Dependencies._

lazy val akkaVersion = "2.5.8"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.8",
    "com.typesafe.akka" %% "akka-testkit" % "2.5.8",
    "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )

  )
