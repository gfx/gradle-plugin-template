package com.github.gfx.gradle_plugin_template

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

import java.util.zip.ZipFile

class FooTask extends DefaultTask {
    @TaskAction
    void run() {
        def content = getResourceContent("resource.txt")
        println(content)

        def extension = project.extensions.getByType(FooExtension)
        println(extension.message)
    }

    String getResourceContent(String filename) {
        URL templateFileUrl = getClass().getClassLoader().getResource(filename)
        if (templateFileUrl == null) {
            throw new GradleException("[${this.tag}] File not found: $filename")
        }

        try {
            return templateFileUrl.openStream().getText("UTF-8")
        } catch (IOException e) {
            // fallback to read JAR directly
            def connection = templateFileUrl.openConnection() as JarURLConnection
            def jarFile = connection.jarFileURL.toURI()
            ZipFile zip
            try {
                zip = new ZipFile(new File(jarFile))
            } catch (FileNotFoundException ex) {
                project.logger.warn("[${this.tag}] No plugin.jar. run `./gradlew plugin:jar` first.")
                throw ex
            }
            return zip.getInputStream((zip.getEntry(filename))).getText("UTF-8")
        }
    }

    String getTag() {
        return this.class.simpleName.replaceFirst(/_Decorated$/, '')
    }
}