plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.sistema_experto"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.sistema_experto"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation("androidx.activity:activity-ktx:${libs.versions.activity.get()}")
    implementation(libs.androidx.constraintlayout)
    
    // Supabase
    implementation("io.github.jan-tennert.supabase:supabase-kt:${libs.versions.supabase.get()}")
    implementation("io.github.jan-tennert.supabase:postgrest-kt:${libs.versions.supabase.get()}")
    implementation("io.github.jan-tennert.supabase:gotrue-kt:${libs.versions.supabase.get()}")
    
    // Ktor Client (requerido por Supabase) - Versión 2.3.12 compatible con Supabase 2.5.0
    implementation("io.ktor:ktor-client-core:${libs.versions.ktor.get()}")
    implementation(libs.ktor.client.android)
    implementation("io.ktor:ktor-client-okhttp:${libs.versions.ktor.get()}")
    implementation("io.ktor:ktor-client-content-negotiation:${libs.versions.ktor.get()}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${libs.versions.ktor.get()}")
    
    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${libs.versions.serialization.get()}")
    
    // Lifecycle
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.runtime)
    
    // Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    
    // RecyclerView
    implementation(libs.recyclerview)
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}