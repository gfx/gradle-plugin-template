package com.github.gfx.gradle_plugin_template

import org.gradle.api.Plugin
import org.gradle.api.Project
// see http://www.gradle.org/docs/current/userguide/custom_plugins.html

public class PluginTemplate implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "Hello, gradle plugin!"
    }
}
