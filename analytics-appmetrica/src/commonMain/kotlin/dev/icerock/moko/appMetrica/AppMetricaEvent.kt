/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
package dev.icerock.moko.appMetrica

interface AppMetricaEvent

class SimpleAppMetricaEvent(
    val id: String? = null,
    val value: String? = null,
) : AppMetricaEvent
