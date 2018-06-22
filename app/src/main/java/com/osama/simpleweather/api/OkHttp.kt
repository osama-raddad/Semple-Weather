package com.osama.simpleweather.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class OkHttp constructor(context: Context, vararg interceptors: Interceptor?) {
    val okHttpClient: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
        for (interceptor: Interceptor? in interceptors)
            builder.interceptors().add(interceptor)
        builder.cache(OkHttpCache.getInstance(context).cache)
        builder.readTimeout(120, TimeUnit.SECONDS)
        builder.connectTimeout(120, TimeUnit.SECONDS)
        okHttpClient = builder.build()
    }
}