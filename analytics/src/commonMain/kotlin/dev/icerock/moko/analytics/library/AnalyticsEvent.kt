/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
package dev.icerock.moko.analytics.library

interface AnalyticsEvent

class SimpleEvent(
    val id: String? = null,
    val value: String? = null,
) : AnalyticsEvent
