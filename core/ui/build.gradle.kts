plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.library.compose)
}

android {
    namespace = "com.example.template.core.ui"

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android dependencies
    implementation(libs.androidx.core.ktx)
}
