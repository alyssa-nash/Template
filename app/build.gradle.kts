plugins {
    alias(libs.plugins.template.android.application)
    alias(libs.plugins.template.android.application.compose)
}

android {
    namespace = "com.example.template"

    defaultConfig {
        applicationId = "com.example.template"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.feature.basic)

    implementation(projects.core.ui)
}