import sbt._
import Keys._

object BlankBuild extends Build {
	val mySettings = Seq(
		scalaVersion := "2.10.1",
		sbtVersion := "0.12.3"
	)

	lazy val root = Project(
		id = "hello",
		base = file("."),
		settings = Defaults.defaultSettings ++ mySettings
	) /* .aggregate(foo, bar)*/
		.dependsOn(foo, bar)


	lazy val foo = Project(
		id = "hello-foo",
		base = file("foo"),
		settings = Defaults.defaultSettings ++ mySettings
	)

	lazy val bar = Project(
		id = "hello-bar",
		base = file("bar"),
		settings = Defaults.defaultSettings ++ mySettings
	)

	aggregate in update := false
}