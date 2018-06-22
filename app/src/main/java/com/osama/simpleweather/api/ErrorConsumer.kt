package com.osama.simpleweather.api

import io.reactivex.functions.Consumer
import timber.log.Timber

fun errorConsumer(): Consumer<Throwable> {
    return Consumer {
        Timber.e(it)
        throw it
    }
}