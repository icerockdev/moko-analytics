/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
package com.icerockdev.library.presentation

import com.icerockdev.library.model.AnalyticsEvent

interface AnalyticsAdapter {
    fun sendEvent(analyticsEvent: AnalyticsEvent)
}