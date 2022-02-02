/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.app

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.amplitude.api.Amplitude
import com.amplitude.api.AmplitudeClient
import com.icerockdev.app.databinding.ActivityMainBinding
import com.icerockdev.library.presentation.AnalyticViewModel
import dev.icerock.moko.analytics.library.analytics.di.AnalyticsTracker
import dev.icerock.moko.analytics.library.analytics.model.SimpleEvent
import dev.icerock.moko.mvvm.createViewModelFactory
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import dev.icerock.moko.mvvm.viewbinding.MvvmEventsActivity


class MainActivity() :
    MvvmEventsActivity<ActivityMainBinding, AnalyticViewModel, AnalyticViewModel.EventsListener>(),
    AnalyticViewModel.EventsListener {
    override val viewModelClass: Class<AnalyticViewModel> = AnalyticViewModel::class.java

    lateinit var amplitudeClient: AmplitudeClient
    lateinit var analyticsTracker: AnalyticsTracker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amplitudeClient = Amplitude.getInstance()
            .initialize(applicationContext, AMPLITUDE_TOKEN)
            .enableForegroundTracking(application)
        binding.buttonEvent.setOnClickListener {
            viewModel.onSendEvent()
        }
    }

    override fun viewBindingInflate(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun viewModelFactory(): ViewModelProvider.Factory {
        return createViewModelFactory { AnalyticViewModel(eventsDispatcher = eventsDispatcherOnMain()) }
    }

    override fun sendEvent(event: String) {
        analyticsTracker.sendEvent(SimpleEvent(event))
    }

    companion object {
        //Add your token for amplitude company
        const val AMPLITUDE_TOKEN = ""
    }
}
