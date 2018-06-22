package com.osama.simpleweather.countryselector

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import com.osama.simpleweather.R
import com.osama.simpleweather.api.City
import com.osama.simpleweather.api.Country

class CitiesAdapter(context: Context, textViewResourceId: Int, private val sities: List<City>) : ArrayAdapter<City>(context, textViewResourceId, sities) {

    private fun getCustomView(position: Int, parent: ViewGroup): View {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false)

        val name = layout.findViewById<TextView>(R.id.name)
        name.text = sities[position].name

        return layout
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View = getCustomView(position, parent)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View = getCustomView(position, parent)
}