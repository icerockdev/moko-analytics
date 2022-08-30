/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
package dev.icerock.moko.analytics

import dev.icerock.moko.amplitude.AmplitudeAdapter
import dev.icerock.moko.amplitude.AmplitudeEvent
import io.github.aakira.napier.Napier

class AnalyticsTracker(private val adapterAmplitudes: List<AmplitudeAdapter>) {

    fun sendEvent(event: AmplitudeEvent) {
        if (adapterAmplitudes.isEmpty()) {
            Napier.e("Analytics adapters is not found")
            return
        }

        for (adapter in adapterAmplitudes) {
            adapter.sendEvent(event)
        }
    }
}
