import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "o1",
    libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.0.0",
    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.5"
  )
