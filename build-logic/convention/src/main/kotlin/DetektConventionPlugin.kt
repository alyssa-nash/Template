import com.example.template.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.kotlin.dsl.configure

/**
 * Gradle convention plugin for Detekt, a static analysis tool for Kotlin. This plugin ensures that
 * the project uses the same Detekt configuration file across all modules.
 */
class DetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with (pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }

            extensions.configure<DetektExtension> {
                buildUponDefaultConfig = true
                config.from(rootProject.file("lint/detekt.yml"))
            }

            dependencies {
                add("detektPlugins", libs.findLibrary("detekt-compose").get())
            }
        }
    }
}