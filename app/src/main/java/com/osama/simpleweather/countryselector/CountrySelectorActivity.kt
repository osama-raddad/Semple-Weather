package com.osama.simpleweather.countryselector

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.osama.simpleweather.App
import com.osama.simpleweather.R
import com.osama.simpleweather.api.City
import com.osama.simpleweather.api.Country
import com.osama.simpleweather.api.errorConsumer
import com.osama.simpleweather.weather.WeatherActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_country_selector.*

class CountrySelectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_selector)
        App[this].service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    countriesSpinner.adapter = CountriesAdapter(this, R.layout.item_country, it)
                    countriesSpinner.visibility = View.VISIBLE
                    countriesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {}
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) = onCountrySelected(it[position])
                    }
                }, errorConsumer(this))
    }

    fun onCountrySelected(country: Country) {
        citiesSpinner.visibility = View.INVISIBLE
        App[this].service.getCities(country.shortName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    citiesSpinner.adapter = CitiesAdapter(this, R.layout.item_city, it)
                    citiesSpinner.visibility = View.VISIBLE
                    citiesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {}
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) = onCitySelected(it[position])
                    }
                }, errorConsumer(this))
    }

    private fun onCitySelected(city: City) {
        next.visibility = View.VISIBLE
        next.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java).apply {
                putExtra("CITY_ID", city.id)
            }
            startActivity(intent)
        }
    }
}
