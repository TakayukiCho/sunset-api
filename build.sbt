lazy val organizationName = "site.sunset"
lazy val mainClassPath = s"$organizationName.Bootstrap"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := organizationName,
      scalaVersion := "2.12.8",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "Sunset",
  )
