import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Gradle convention plugin for Spotless, a plugin that runs Ktlint, a Kotlin formatting linter.
 * This plugin ensures that the project uses the same Spotless & Ktlint configuration file across
 * all modules.
 */
class SpotlessConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.diffplug.spotless")
            }

            extensions.configure<SpotlessExtension> {
                ratchetFrom("origin/main")
                kotlin {
                    target("**/*.kt")
                    ktlint()
                        .setEditorConfigPath("$rootDir/lint/.editorconfig")
                }
                kotlinGradle {
                    target("**/*.gradle.kts")
                    ktlint()
                }
            }
        }
    }
}
