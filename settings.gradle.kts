pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
    }
}

val modName: String by extra
val minecraftVersion: String by extra
rootProject.name = "$modName-$minecraftVersion"
