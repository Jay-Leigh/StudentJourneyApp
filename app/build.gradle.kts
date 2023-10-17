plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {
    namespace = "com.example.studentjourney"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.studentjourney"
        minSdk = 33
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    //Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))

    implementation("androidx.core:core-ktx:1.12.0")

    // Add the dependency for the Realtime Database library
    implementation("com.google.firebase:firebase-database-ktx")

    // Add the dependency for the Firebase Authentication library
    implementation("com.google.firebase:firebase-auth-ktx")

    // Also add the dependency for the Google Play services library and specify its version
    implementation("com.google.android.gms:play-services-auth:20.7.0")

    // Add the dependency for the Cloud Storage library
    implementation("com.google.firebase:firebase-storage-ktx")

    // Adding materials for extra resources
    implementation("com.google.android.material:material:1.10.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

    //Library
    implementation("com.github.eddydn:videoplayer:1.10")
    implementation("com.google.android.exoplayer:exoplayer:2.19.1")
    implementation("com.facebook.shimmer:shimmer:0.1.0@aar")
    implementation("androidx.recyclerview:recyclerview:1.3.1@aar")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}