plugins {
    alias(libs.plugins.template.android.feature)
    alias(libs.plugins.template.android.library.compose)
}

android {
    namespace = "com.example.template.feature.basic"
}

dependencies {
    implementation(projects.core.ui)
}
