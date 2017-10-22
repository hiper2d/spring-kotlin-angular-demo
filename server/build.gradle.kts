import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
    plugin("org.jetbrains.kotlin.jvm")
    plugin("org.jetbrains.kotlin.plugin.spring")
    plugin("org.jetbrains.kotlin.plugin.jpa")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

dependencies {
    compile ("org.jetbrains.kotlin:kotlin-stdlib-jre8")
    compile ("org.jetbrains.kotlin:kotlin-reflect")
    compile ("org.springframework.boot:spring-boot-starter-webflux")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

