package com.lcyy

import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello") {
            description = "com.lcyy.GreetingPlugin.apply"
            doLast {
                println("Hello from the GreetingPlugin")
            }
        }
    }
}