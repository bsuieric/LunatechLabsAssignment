name := """LunatechLabsApp"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

//javaOption += Seq("-Dconfig.file=conf/test.conf")

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.2.9.Final",
  "dom4j" % "dom4j" % "1.6.1" intransitive(),
  "org.mockito" % "mockito-core" % "2.1.0"
)




