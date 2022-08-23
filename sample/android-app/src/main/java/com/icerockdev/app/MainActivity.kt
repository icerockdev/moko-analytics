/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.app

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.amplitude.api.Amplitude
import com.amplitude.api.AmplitudeClient
import com.google.firebase.analytics.FirebaseAnalytics
import com.icerockdev.app.databinding.ActivityMainBinding
import com.icerockdev.library.presentation.AnalyticViewModel
import dev.icerock.moko.analytics.library.AnalyticsTracker
import dev.icerock.moko.analytics.library.SimpleEvent
import dev.icerock.moko.mvvm.createViewModelFactory
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import dev.icerock.moko.mvvm.viewbinding.MvvmEventsActivity

class MainActivity :
    MvvmEventsActivity<ActivityMainBinding, AnalyticViewModel, AnalyticViewModel.EventsListener>(),
    AnalyticViewModel.EventsListener {
    override val viewModelClass: Class<AnalyticViewModel> = AnalyticViewModel::class.java

    lateinit var amplitudeClient: AmplitudeClient
    lateinit var analyticsTracker: AnalyticsTracker
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Init Firebase analytic
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "my_item_id")

        //Init Amplitude analytic
        amplitudeClient = Amplitude.getInstance()
            .initialize(applicationContext, AMPLITUDE_TOKEN)
            .enableForegroundTracking(application)

        binding.buttonAmplitudeEvent.setOnClickListener {
            viewModel.onSendEvent()
        }

        binding.buttonFirebaseEvent.setOnClickListener {
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }
    }

    override fun viewBindingInflate(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun viewModelFactory(): ViewModelProvider.Factory {
        return createViewModelFactory {
            AnalyticViewModel(
                eventsDispatcher = eventsDispatcherOnMain()
            )
        }
    }

    override fun sendEvent(event: String) {
        analyticsTracker.sendEvent(SimpleEvent(event))
    }

    companion object {
        //Add your token for amplitude company
        const val AMPLITUDE_TOKEN = ""
    }
}
