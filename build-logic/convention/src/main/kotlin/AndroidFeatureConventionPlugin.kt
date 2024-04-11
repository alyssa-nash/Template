import com.android.build.gradle.LibraryExtension
import com.example.template.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * Gradle convention plugin for Android feature modules
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("template.android.library")
                apply("de.mannodermaus.android-junit5")
                apply("template.detekt")
                apply("template.spotless")
            }
            extensions.configure<LibraryExtension> {
                // Set the test runner to the default AndroidX test runner
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                // Disable animations for tests
                testOptions.animationsDisabled = true

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
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
