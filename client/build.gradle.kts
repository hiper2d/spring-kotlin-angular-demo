import com.moowork.gradle.node.NodeExtension
import com.moowork.gradle.node.npm.NpmTask

apply {
    plugin("com.moowork.node")
}

configure<NodeExtension> {
    version = "6.11.4"
    npmVersion = "5.3.0"
    // If true, it will download node using above parameters.
    // If false, it will try to use globally installed node.
    download = false
}

tasks {
    "npmRun"(type = NpmTask::class) {
        setArgs(listOf("start"))
    }
}