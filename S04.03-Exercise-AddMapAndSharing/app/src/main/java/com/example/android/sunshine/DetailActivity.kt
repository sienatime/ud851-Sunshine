package com.example.android.sunshine

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private var mForecast: String? = null
    private var mWeatherDisplay: TextView? = null
    private val FORECAST_SHARE_HASHTAG = " #SunshineApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mWeatherDisplay = findViewById(R.id.tv_display_weather) as TextView

        val intentThatStartedThisActivity = intent

        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                mForecast = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
                mWeatherDisplay!!.text = mForecast
            }
        }
    }

    // TODO (3) Create a menu with an item with id of action_share
    // TODO (4) Display the menu and implement the forecast sharing functionality
}