rootProject.name = "hibernate-mine-sweeper"

include(
    "pojo",
    "mine:n-plus-one",
    "mine:duplicate-query",
    "sweeper"
)

pluginManagement {
	repositories {
		mavenCentral()
		gradlePluginPortal()
	}
}

dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			from(files("libs.versions.toml"))
		}
	}
}
