package com.example.template

import com.android.build.api.dsl.CommonExtension
import com.example.template.Variables.COMPILE_SDK
import com.example.template.Variables.MIN_SDK
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Configure base Kotlin with Android options. This will be used for all modules.
 */
internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = COMPILE_SDK

        defaultConfig {
            minSdk = MIN_SDK
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1,LICENSE.*,LICENSE-notice.md}"
            }
        }
    }

    configureKotlin()
}

/**
 * Configure base Kotlin options
 */
private fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()

            // Treat all Kotlin warnings as errors (disabled by default)
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()

            // Enable experimental coroutines API, including Flow
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            )
        }
    }
}
