plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.junit5.wrapper)
}

android {
    namespace = "com.example.template.konsistTest"
}

dependencies {
    // For import and annotation reference only
    testImplementation(platform(libs.androidx.compose.bom))
    testImplementation(libs.androidx.ui.tooling.preview)

    testImplementation(libs.konsist)
    testImplementation(libs.jupiter.api)
    testRuntimeOnly(libs.jupiter.engine)
}
