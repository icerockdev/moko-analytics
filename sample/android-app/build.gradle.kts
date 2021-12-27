/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("android-app-convention")
    id("kotlin-parcelize")
}

android {
    buildFeatures.viewBinding = true
    defaultConfig {
        applicationId = "dev.icerock.moko.samples.analytics"

        versionCode = 1
        versionName = "0.1.0"
    }
}

dependencies {
    implementation(libs.appCompat)
    implementation(libs.material)
    implementation(libs.mokoMvvmViewBinding)
    implementation(libs.amplitudude)

    implementation(projects.sample.mppLibrary)
}

