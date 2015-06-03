name := "funml"

version := "0.0.1"

organization := "io.malcolmgreaves"

scalaVersion := "2.11.6"

val jvm = "1.8"

resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Twitter Repository" at "http://maven.twttr.com/"
)

val axleVer = "0.2.0-SNAPSHOT"

val dl4jVer = "0.0.3.3"

libraryDependencies ++= Seq(
  //
  // Visualization
  //
  // wisp is scala plotting
  "com.quantifind" %% "wisp" % "0.0.1",
  //
  // Concurrent and Distributed 
  //
  // spark
  "org.apache.spark" %% "spark-core" % "1.2.0",
  //
  // Math, ML, NLP, Statistics, Numerical, Scientific
  //
  // sista
  "edu.arizona.sista" % "processors" % "3.3",
  "edu.arizona.sista" % "processors" % "3.3" classifier "models",
  // spire
  "org.spire-math" %% "sire" % "0.9.1",
  // scalanlp
  "org.scalanlp" % "breeze-core_2.10" % "0.4",
  "org.scalanlp" % "breeze-math_2.10" % "0.4",
  "org.scalanlp" % "nak" % "1.1.3",
  "org.scalanlp" % "chalk" % "1.2.0",
  // axle
  "org.axle-lang" %% "axle-core" % axleVer,
  "org.axle-lang" %% "axle-games" % axleVer,
  "org.axle-lang" %% "axle-visualize" % axleVer,
  "org.axle-lang" %% "axle-jblas" % axleVer,
  "org.axle-lang" %% "axle-joda" % axleVer,
  "org.axle-lang" %% "axle-jung" % axleVer,
  // deeplearning4j
  "org.deeplearning4j" % "dl4j-spark-nlp" % dl4jVer,
  "org.deeplearning4j" % "dl4j-spark" % dl4jVer,
  "org.deeplearning4j" % "deeplearning4j-core" % dl4jVer,
  "org.deeplearning4j" % "deeplearning4j-scaleout" % dl4jVer,
  "org.deeplearning4j" % "deeplearning4j-ui" % "0.0.3.3.3.alpha1", // avail for this one only
  // nd4j
  "org.nd4j" % "nd4j-scala-api" % "0.0.3.5.5.5",
  "org.nd4j" % "canova-parent" % "0.0.0.4",
  "org.nd4j" % "nd4j-netlib-blas" % "0.0.3.5.5.5",
  "org.nd4j" % "nd4j-jcublas-common" % "0.0.3.5.5.5",
  //"org.nd4j" % "nd4j-jcublas-osx-6.5" % "0.0.3.5.5.2",
  //
  // Util
  //
  "com.github.scopt" %% "scopt" % "3.3.0",
  //
  // Testing
  //
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

scalacOptions ++= Seq(
  s"-target:jvm-$jvm",
  "-optimize",
  "-Xfatal-warnings",
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:postfixOps",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:experimental.macros",
  "-unchecked",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Yinline-warnings"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

testOptions in Test += Tests.Argument("-oF")

packAutoSettings

defaultScalariformSettings

fork in Test := false

parallelExecution in Test := false

//ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := "*.app\\.*"

