// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false // Gerencia o plugin de aplicação Android
    alias(libs.plugins.jetbrains.kotlin.android) apply false // Gerencia o Kotlin para Android
    id("com.google.devtools.ksp") version "2.0.20-1.0.25" apply false // Plugin KSP para processamento de anotações
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20" apply false // Plugin para Jetpack Compose
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
