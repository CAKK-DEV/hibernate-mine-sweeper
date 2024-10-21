rootProject.name = "hibernate-mine-sweeper"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.6.0"
}

// Module
module(name=":pojo", "pojo")

module(name=":mine-core", "mine")
module(name=":npo-mine", "mine/n-plus-one")
module(name=":dq-mine", "mine/duplicate-query")

module(name=":sweeper", "sweeper")

dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			from(files("libs.versions.toml"))
		}
	}
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

fun module(name: String, path: String) {
    include(name)
    project(name).projectDir = file(path)
}
