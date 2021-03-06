val ScalatraVersion = "2.6.5"

name := "ApiDoc"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % "3.2.3",
    "org.slf4j" % "slf4j-api" % "1.7.7",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3",
    //"org.xerial" % "sqlite-jdbc" % "3.25.2",
    "mysql" % "mysql-connector-java" % "6.0.6",
    "com.typesafe.slick" %% "slick-codegen" % "3.2.3",
    "org.scalatra" %% "scalatra" % ScalatraVersion,
    "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "project",
    "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
    "org.eclipse.jetty" % "jetty-webapp" % "9.4.19.v20190610" % "container;compile",
    "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
    "com.mchange" % "c3p0" % "0.9.5.2",
    "org.scalatra" %% "scalatra-json" % ScalatraVersion,
    "org.json4s" %% "json4s-jackson" % "3.5.3",
    "com.lihaoyi" %% "requests" % "0.2.0",
    // html to pdf
    "com.itextpdf" % "itextpdf" % "5.4.3",
    "com.itextpdf" % "html2pdf" % "2.1.4",
    "com.itextpdf" % "font-asian" % "7.1.2",
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)