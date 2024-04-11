import com.android.build.api.dsl.ApplicationExtension
import com.example.template.configureAndroidCompose
import com.example.template.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.dependencies

/**
 * Gradle convention plugin to configure Android Compose for an application module. Should only be
 * applied to application modules that are using Compose. Only add dependencies and configurations
 * here that are shared across all application modules using Compose.
 */
class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)

            dependencies {
                "implementation"(libs.findLibrary("androidx.activity.compose").get())
            }
        }
    }
}
