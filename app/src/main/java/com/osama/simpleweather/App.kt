package com.osama.simpleweather

import android.app.Activity
import android.app.Application
import com.osama.simpleweather.api.API
import com.osama.simpleweather.api.ServiceGenerator
import timber.log.Timber


class App : Application() {
    val service: API get() = ServiceGenerator(this).retrofit.create(API::class.java)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        operator fun get(activity: Activity): App {
            return activity.application as App
        }
    }
}
