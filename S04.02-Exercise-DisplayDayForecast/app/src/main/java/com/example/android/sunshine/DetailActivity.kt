package com.example.android.sunshine

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private val FORECAST_SHARE_HASHTAG = " #SunshineApp"
    private var weatherText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        weatherText = findViewById(R.id.weather_detail) as TextView

        // Completed TODO (2) Display the weather forecast that was passed from MainActivity
        val intent = intent
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            weatherText?.setText(intent.getStringExtra(Intent.EXTRA_TEXT))
        }
    }

}