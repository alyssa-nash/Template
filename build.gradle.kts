// Top-level build file where you can add configuration options common to all sub-projects/modules.

// Lists all plugins used throughout the project
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.junit5.wrapper) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.spotless) apply false
}
