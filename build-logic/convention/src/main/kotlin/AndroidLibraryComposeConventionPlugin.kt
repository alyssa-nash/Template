import com.android.build.gradle.LibraryExtension
import com.example.template.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Gradle convention plugin to configure Android Compose for a library module. Should only be
 * applied to library modules that are using Compose. Only add dependencies and configurations
 * here that are shared across all library modules using Compose.
 */
class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}
