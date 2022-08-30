/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}
includeBuild("analytics-build-logic")

include(":analytics-core")
include(":analytics-amplitude")
include(":analytics-firebase")
include(":analytics-appMetrica")
include(":sample:android-app")
include(":sample:mpp-library")
include(":mpp-library:analytic-amplitude")
