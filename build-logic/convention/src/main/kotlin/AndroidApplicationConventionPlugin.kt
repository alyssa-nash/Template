import com.android.build.api.dsl.ApplicationExtension
import com.example.template.Variables.TARGET_SDK
import com.example.template.configureKotlinAndroid
import com.example.template.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * Gradle convention plugin for Android application modules
 */
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("de.mannodermaus.android-junit5")
                apply("template.detekt")
                apply("template.spotless")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = TARGET_SDK

                // Configure Kotlin with Android options
                configureKotlinAndroid(this)

                // Enable lint checks for dependencies
                lint.checkDependencies = true

                // Disable animations for tests
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true
            }

            dependencies {
                // Jupiter API and Engine are required for JUnit 5 tests
                add("testImplementation", libs.findLibrary("jupiter-api").get())
                add("testRuntimeOnly", libs.findLibrary("jupiter-engine").get())
                add("androidTestImplementation", libs.findLibrary("jupiter-api").get())
            }
        }
    }
}
