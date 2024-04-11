import com.android.build.gradle.LibraryExtension
import com.example.template.Variables.TARGET_SDK
import com.example.template.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Gradle convention plugin for Android library modules
 */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("template.detekt")
                apply("template.spotless")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig.targetSdk = TARGET_SDK

                // Disable animations for tests
                testOptions.animationsDisabled = true

                // Configure Kotlin with Android options
                configureKotlinAndroid(this)

                // The resource prefix is derived from the module name, so resources inside
                // ":core:module1" must be prefixed with "core_module1_"
                resourcePrefix =
                    path.split("""\W""".toRegex())
                        .drop(1)
                        .distinct()
                        .joinToString(separator = "_")
                        .lowercase() + "_"
            }
        }
    }
}
