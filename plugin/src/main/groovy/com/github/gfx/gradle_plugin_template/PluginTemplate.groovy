package com.github.gfx.gradle_plugin_template

import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project

import java.util.zip.ZipException
import java.util.zip.ZipFile

// see http://www.gradle.org/docs/current/userguide/custom_plugins.html

public class PluginTemplate implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.add("foo", FooExtension as Object)

        project.task("foo", type: FooTask)
    }
}
