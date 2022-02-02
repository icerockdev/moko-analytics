/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.library.di

import com.icerockdev.library.model.AnalyticsEvent
import com.icerockdev.library.presentation.AnalyticsAdapter
import io.github.aakira.napier.Napier


class AnalyticsTracker(private val adapterAmplitudes: List<AnalyticsAdapter>) {

    fun sendEvent(event: AnalyticsEvent) {
        if (adapterAmplitudes.isEmpty()) {
            Napier.e("Analytics adapters is not found")
            return
        }

        for (adapter in adapterAmplitudes) {
            adapter.sendEvent(event)
        }
    }
}
