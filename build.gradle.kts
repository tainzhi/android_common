import com.tainzhi.android.buildsrc.Libs

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Libs.Configs.compileSdkVersion)
    buildToolsVersion(Libs.Configs.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Libs.Configs.minSdkVersion)
        targetSdkVersion(Libs.Configs.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    api(Libs.Kotlin.stdlib)
    api(Libs.AndroidX.Lifecycle.viewmodelKtx)
    api(Libs.AndroidX.Lifecycle.livedata)
    api(Libs.AndroidX.appcompat)
    api(Libs.AndroidX.coreKtx)
    api(Libs.AndroidX.constraintlayout)
    api(Libs.Google.material)
    api(Libs.Coroutines.android)
    api(Libs.Retrofit.retrofit)
    api(Libs.Retrofit.moshiConverter)
    api(Libs.Moshi.moshi)
    kapt(Libs.Moshi.codeGen)
    api(Libs.OkHttp.loggingInterceptor)
    api(Libs.Glide.glide)

}