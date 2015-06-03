name := "rex"

version := "0.0.1"

organization := "io.malcolmgreaves"

scalaVersion := "2.10.5"

val jvm = "1.7"

resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Twitter Repository" at "http://maven.twttr.com/"
)

libraryDependencies ++= Seq(
  // Visualization
  "com.quantifind" %% "wisp" % "0.0.1",
  // NLP
  "edu.arizona.sista" % "processors" % "3.3",
  "edu.arizona.sista" % "processors" % "3.3" classifier "models",
  // "org.scalanlp" % "chalk" % "1.2.0",
  // Concurrent and Distributed 
  "org.apache.spark" %% "spark-core" % "1.2.0",
  // Math
  "org.spire-math" %% "spire" % "0.9.1",
  "org.scalanlp" % "breeze-core_2.10" % "0.4",
  "org.scalanlp" % "breeze-math_2.10" % "0.4",
  // ML
  "org.scalanlp" % "nak" % "1.1.3",
  // Util
  "com.github.scopt" %% "scopt" % "3.3.0",
  // Testing
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

val customScalacOptions = Seq(
  s"-target:jvm-$jvm",
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:experimental.macros",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Yinline-warnings"
)

scalacOptions ++= (customScalacOptions :+ "-optimize")

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

testOptions in Test += Tests.Argument("-oF")

packAutoSettings

defaultScalariformSettings

fork in Test := false

parallelExecution in Test := false

ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := "*.app\\.*"

