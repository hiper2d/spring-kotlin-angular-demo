import com.palantir.gradle.docker.DockerExtension
import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Need this to help compile .kts scripts
    java
}

apply {
    plugin("org.jetbrains.kotlin.jvm")
    plugin("org.jetbrains.kotlin.plugin.spring")
    plugin("org.jetbrains.kotlin.plugin.jpa")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("com.palantir.docker")
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jre8")
    implementation ("org.jetbrains.kotlin:kotlin-reflect")
    implementation ("org.springframework.boot:spring-boot-starter-webflux")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

val jar: Jar by tasks

configure<DockerExtension> {
    name = "${group}/${jar.baseName}:${jar.version}"
    files(jar.outputs)
    buildArgs(mapOf(
            "JAR_NAME" to jar.archiveName,
            "PORT"   to  "8082",
            "JAVA_OPTS" to ""
    ))
    pull(true)
}
