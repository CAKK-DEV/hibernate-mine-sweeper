import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
    `maven-publish`
}

allprojects {
    group = "${property("projectGroup")}"
    version = "${property("version")}"

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.jmailen.kotlinter")
    apply(plugin = "maven-publish")

    kotlin {
        compilerOptions {
            apiVersion = KotlinVersion.KOTLIN_2_1
            languageVersion = KotlinVersion.KOTLIN_2_1
            freeCompilerArgs = listOf(
                "-Xjsr305=strict",
            )

        }
    }

    dependencies {
        implementation(rootProject.libs.kotlin)

        testImplementation(rootProject.libs.junit)
        testImplementation(rootProject.libs.mockk)
        testImplementation(rootProject.libs.kotest)
    }

    tasks.withType<Test> {
        useJUnitPlatform()

        testLogging {
            showExceptions = true
            exceptionFormat = FULL
            showCauses = true
            showStackTraces = true
            events = setOf(FAILED)
        }
    }
}
