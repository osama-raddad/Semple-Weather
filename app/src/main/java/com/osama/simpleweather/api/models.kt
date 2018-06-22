package com.osama.simpleweather.api

import com.google.gson.annotations.SerializedName


data class Country(@SerializedName("shortName") var shortName: String = "",
                   @SerializedName("name") var name: String = "",
                   @SerializedName("emoji") var emoji: String = "")

data class City(@SerializedName("id") var id: String = "",
                @SerializedName("name") var name: String = "")

data class Weather(@SerializedName("temp") var temp: String = "",
                   @SerializedName("pressure") var pressure: String = "",
                   @SerializedName("humidity") var humidity: String = "",
                   @SerializedName("temp_min") var tempMin: String = "",
                   @SerializedName("temp_max") var tempMax: String = "")