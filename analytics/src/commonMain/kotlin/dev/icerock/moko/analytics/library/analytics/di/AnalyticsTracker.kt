/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
package dev.icerock.moko.analytics.library.analytics.di

import dev.icerock.moko.analytics.library.analytics.model.AnalyticsEvent
import dev.icerock.moko.analytics.library.analytics.presentation.AnalyticsAdapter

class AnalyticsTracker(private val adapterAmplitudes: List<AnalyticsAdapter>) {

    fun sendEvent(event: AnalyticsEvent) {
        if (adapterAmplitudes.isEmpty()) {
            return
        }

        for (adapter in adapterAmplitudes) {
            adapter.sendEvent(event)
        }
    }
}
