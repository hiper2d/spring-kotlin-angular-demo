buildscript {
    val springBootVersion = "2.0.0.M4"

    repositories {
        mavenCentral()
        maven { setUrl("https://repo.spring.io/milestone") }
    }
    dependencies {
        // Use this plugin together with 'dependency-management' to avoid specifying Spring versions in dependencies.
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
}

plugins {
    val kotlinVersion = "1.1.50"

    base
    // 'kotlin.jvm' plugin should present in each build.gradle.kts file to help them to compile.
    id ("org.jetbrains.kotlin.jvm") version kotlinVersion

    // This two plugins helps to use Spring and Jps annotations with Kotlin without magic.
    id ("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
    id ("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion apply false
}

subprojects {
    repositories {
        jcenter()
        mavenCentral()
        maven ("https://repo.spring.io/milestone")
        maven ("https://repo.spring.io/snapshot")
    }
}