buildscript {
    val springBootVersion = "2.0.0.M4"

    repositories {
        jcenter()
        maven { setUrl("https://repo.spring.io/milestone") }
    }
    dependencies {
        // Use this plugin with build-in 'dependency-management' plugin to avoid specifying Spring versions in dependencies.
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
}

plugins {
    val kotlinVersion = "1.1.51"
    val nodePluginVersion = "1.2.0"
    val dockerPluginVersion = "0.13.0"

    base
    id ("org.jetbrains.kotlin.jvm") version kotlinVersion
    id ("com.palantir.docker") version dockerPluginVersion apply false
    id ("com.moowork.node") version nodePluginVersion apply false

    // This two plugins helps to use Spring and Jps annotations/entities with Kotlin without magic.
    id ("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
    id ("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion apply false
}

subprojects {
    repositories {
        jcenter()
        maven ("https://repo.spring.io/milestone")
    }
}