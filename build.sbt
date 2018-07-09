name := "scala-gemfire-prac"

version := "0.1"

scalaVersion := "2.12.4"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

// https://mvnrepository.com/artifact/org.apache.geode/geode-core
libraryDependencies += "org.apache.geode" % "geode-core" % "1.0.0-incubating"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.apache.commons" % "commons-math3" % "3.0"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.1.2"
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.2"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.12"
libraryDependencies += "de.heikoseeberger" %% "akka-http-play-json" % "1.21.0"
