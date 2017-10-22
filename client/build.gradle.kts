import com.moowork.gradle.node.NodeExtension
import com.moowork.gradle.node.npm.NpmTask
import com.palantir.gradle.docker.DockerExtension

apply {
    plugin("com.moowork.node")
    plugin("com.palantir.docker")
}

tasks {
    "npmStart"(type = NpmTask::class) {
        setArgs(listOf("start"))
    }
    "npmProdBuild"(type = NpmTask::class) {
        setArgs(listOf("run", "prod"))
    }
    "copyNginxConfigToDockerBuild"(type = Copy::class) {
        from("config/nginx")
        into("build/docker/config/nginx")
        dependsOn(tasks.findByName("dockerPrepare"))
    }
    "copyDistToDockerBuild"(type = Copy::class) {
        from("dist")
        into("build/docker/dist")
        dependsOn(tasks.findByName("dockerPrepare"))
    }
}

configure<NodeExtension> {
    version = "6.11.4"
    npmVersion = "5.3.0"
    download = false
}

configure<DockerExtension> {
    name = "${group}/angular-client"
    pull(true)
}

tasks.findByName("docker")?.dependsOn("copyDistToDockerBuild", "copyNginxConfigToDockerBuild")