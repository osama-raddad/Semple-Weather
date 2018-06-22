package com.osama.simpleweather.api

import android.content.Context
import android.widget.Toast
import io.reactivex.functions.Consumer
import timber.log.Timber

fun errorConsumer(context: Context): Consumer<Throwable> {
    return Consumer {
        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()

        Timber.e(it)
        throw it
    }
}