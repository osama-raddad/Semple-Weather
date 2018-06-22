package com.osama.simpleweather.weather

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.osama.simpleweather.App
import com.osama.simpleweather.R
import com.osama.simpleweather.api.errorConsumer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        App[this].service.getWeather(intent.getStringExtra("CITY_ID"))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    humidity.text = "humidity ${it.humidity}"
                    pressure.text = "pressure ${it.pressure}"
                    temp.text = "temp ${it.temp}"
                    temp_max.text = "tempMax ${it.tempMax}"
                    temp_min.text = "tempMin ${it.tempMin}"
                }, errorConsumer(this))
    }
}
