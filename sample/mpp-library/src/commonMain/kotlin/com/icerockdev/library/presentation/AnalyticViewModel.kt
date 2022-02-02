/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.library.presentation

import com.icerockdev.library.model.AnalyticsEventConstants.SIMPLE_EVENT
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class AnalyticViewModel(
    override val eventsDispatcher: EventsDispatcher<EventsListener>,
) : ViewModel(), EventsDispatcherOwner<AnalyticViewModel.EventsListener> {

    fun onSendEvent() {
        eventsDispatcher.dispatchEvent { sendEvent(SIMPLE_EVENT) }
    }

    interface EventsListener {
        fun sendEvent(event: String)
    }
}