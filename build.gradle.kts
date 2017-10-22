buildscript {
    val springBootVersion = "2.0.0.M4"

    repositories {
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

    base
    // 'kotlin.jvm' plugin should present in each build.gradle.kts file to help them to compile.
    id ("org.jetbrains.kotlin.jvm") version kotlinVersion

    // This two plugins helps to use Spring and Jps annotations/entities with Kotlin without magic.
    id ("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
    id ("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion apply false

    id ("com.moowork.node") version nodePluginVersion apply false
}

subprojects {
    repositories {
        jcenter()
        maven ("https://repo.spring.io/milestone")
    }
}