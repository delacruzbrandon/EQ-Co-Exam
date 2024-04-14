plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.clutchit.emotionalintelligencecoexam"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.clutchit.emotionalintelligencecoexam"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors"
            excludes += "META-INF/DEPENDENCIES"
        }
    }

    packagingOptions {
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.core.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.io.coil)
    implementation(libs.androidx.ui.text.google.fonts )
    implementation(libs.androidx.constraintlayout.compose)

    // API Trinity
    implementation(libs.com.retrofit)
    implementation(libs.com.gson)
    implementation(libs.com.gson.converter)
    implementation(libs.com.okhttp)

    // Koin
    implementation(libs.io.koin.android)
    implementation(libs.io.koin.androidx.navigation)
    implementation(libs.io.koin.androidx.compose)
    testImplementation(libs.io.koin.test)

    // Unit Testing
    testImplementation(libs.junit)
    testImplementation(libs.org.mockito.core)
    testImplementation(libs.org.mockito.inline)
    testImplementation(libs.com.okhttp.mockwebserver)
    testImplementation(libs.org.kotlinx.coroutines.test)

    implementation(libs.org.pdfbox)



}