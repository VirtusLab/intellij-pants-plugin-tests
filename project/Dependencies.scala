import sbt._

object Dependencies {
  val junit = Seq(
    "junit" % "junit" % "4.12" % Test,
    ("com.novocode" % "junit-interface" % "0.11" % Test).exclude("junit", "junit-dep")
  )

  object ideProbe {
    //val version = "0.2.2+32-04847549+20201029-1813-SNAPSHOT"
    val version = "0.2.2"

    val resolvers = Seq(
      Resolver.sonatypeRepo("public"),
      Resolver.sonatypeRepo("snapshots"),
      MavenRepository("jetbrains-3rd", "https://jetbrains.bintray.com/intellij-third-party-dependencies")
    )

    def apply(name: String): ModuleID = {
      "org.virtuslab.ideprobe" %% name % version
    }

    val api = apply("api")
    val driver = apply("driver")
    val jUnitDriver = apply("junit-driver")
    val probePlugin = apply("probe-plugin")
    val probeScalaDriver = apply("scala-probe-driver")
    val robotDriver = apply("robot-driver")
  }

}
