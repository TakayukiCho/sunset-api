import java.io.File
import com.typesafe.config.ConfigFactory

val configFile = new File(sys.env.getOrElse("CONFIG_FILE", "src/main/resources/application.conf"))
val applicationConf = ConfigFactory.parseFile(configFile)
val dbConf = applicationConf.getConfig("db.default").resolve()

lazy val scalikejdbcVersion = "3.3.2"
lazy val organizationName = "site.sunset"
lazy val mainClassPath = s"$organizationName.Bootstrap"


lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := organizationName,
      scalaVersion := "2.12.8",
      version := "0.1.0-SNAPSHOT"
    )),
    mainClass in (Compile, run) := Some(mainClassPath),
    libraryDependencies ++= Seq(
      "org.postgresql" % "postgresql" % "42.1.4",
      "ch.qos.logback"  %  "logback-classic"   % "1.2.3",
      "org.scalikejdbc" %% "scalikejdbc"       %  scalikejdbcVersion,
      "org.scalikejdbc" %% "scalikejdbc-config" % scalikejdbcVersion,
      "org.scalikejdbc" %% "scalikejdbc-syntax-support-macro" % scalikejdbcVersion,
    ),
    name := "Sunset",
    flywayUrl := dbConf.getString("url"),
    flywayUser := dbConf.getString("user"),
    flywayPassword := dbConf.getString("password")
  ).enablePlugins(FlywayPlugin)

