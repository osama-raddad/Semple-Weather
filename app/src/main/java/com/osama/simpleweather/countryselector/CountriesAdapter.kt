package com.osama.simpleweather.countryselector

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import com.osama.simpleweather.R
import com.osama.simpleweather.api.Country

class CountriesAdapter(context: Context, textViewResourceId: Int, private val countries: List<Country>) : ArrayAdapter<Country>(context, textViewResourceId, countries) {

    private fun getCustomView(position: Int, parent: ViewGroup): View {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false)

        val name = layout.findViewById<TextView>(R.id.name)
        val emoji = layout.findViewById<TextView>(R.id.emoji)

        name.text = countries[position].name
        emoji.text = countries[position].emoji


        return layout
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View = getCustomView(position, parent)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View = getCustomView(position, parent)
}