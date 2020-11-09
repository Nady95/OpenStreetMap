import org.gradle.jvm.tasks.Jar

plugins {
  java
  id("com.github.johnrengelman.shadow")
}

tasks.shadowJar {
  archiveClassifier.set("")
  archiveVersion.set("")
  manifest {
    attributes["Main-Class"] = "io.github.joxit.pizzeria.vertx.VertexExample"
  }
}

dependencies {
  implementation(project(":pizzeria-core"))
  implementation("org.springframework:spring-jdbc")
  implementation("org.springframework:spring-context")
  implementation("org.springframework:spring-orm")
  implementation("org.springframework.data:spring-data-jpa")

  implementation("io.vertx:vertx-web:${property("version.vertx")}")
  implementation("javax.annotation:javax.annotation-api:${property("version.javax")}")
  implementation("org.javassist:javassist:${property("version.javassist")}")
}
