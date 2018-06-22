package com.osama.simpleweather.api

import com.google.gson.JsonObject
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface API {
    @GET("weather/{city_id}")
    fun getWeather(@Path("city_id") cityId: String): Single<Weather>

    @GET("cities/{country_code}")
    fun getCities(@Path("country_code") countryCode: String): Single<List<City>>

    @GET("countries")
    fun getCountries(): Single<List<Country>>
}
