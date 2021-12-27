/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.analytics.library.analytics.presentation

import dev.icerock.moko.analytics.library.analytics.model.AnalyticsEvent

interface AnalyticsAdapter {
    fun sendEvent(analyticsEvent: AnalyticsEvent)
}