/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
package com.icerockdev.library.model

interface AnalyticsEvent

class SimpleEvent(
    val id: String? = null,
    val value: String? = null,
) : AnalyticsEvent
