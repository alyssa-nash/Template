package com.example.template

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configures Android Compose for the given project. Only add dependencies and configurations here
 * that are shared across all modules using Compose.
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add("implementation", platform(bom))
            add("implementation", libs.findLibrary("androidx-material3").get())
            add("implementation", libs.findLibrary("androidx-ui-tooling-preview").get())

            // Junit 5 for Compose
            add("androidTestImplementation", libs.findLibrary("junit5-compose").get())
            add("debugImplementation", libs.findLibrary("androidx-ui-test-manifest").get())
        }
    }
}
