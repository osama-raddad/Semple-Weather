package com.osama.simpleweather.api

import android.content.Context
import com.osama.simpleweather.api.BASE_URL
import com.osama.simpleweather.api.OkHttp
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ServiceGenerator(context: Context) {
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttp(context).okHttpClient)
            .build()

}