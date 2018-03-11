package com.example.android.sunshine.viewmodels

import android.content.Context
import android.database.Cursor
import com.example.android.sunshine.DetailActivity
import com.example.android.sunshine.MainActivity
import com.example.android.sunshine.R
import com.example.android.sunshine.utilities.SunshineDateUtils
import com.example.android.sunshine.utilities.SunshineWeatherUtils

/**
 * Created by siena on 3/10/18.
 */
class WeatherDetailViewModel(_context: Context, _data: Cursor) {
    val context = _context;
    val data = _data;

    val date: String
    val description: String
    val highTemp: String;
    val lowTemp: String;
    val wind: String
    val humidity: String
    val pressure: String
    val summary: String;

    init {
        date = formatDate()
        description = formatDescription()
        highTemp = formatHighTemp()
        lowTemp = formatLowTemp()
        wind = formatWind()
        humidity = formatHumidity()
        pressure = formatPressure()
        summary = formatSummary()
    }

    private fun formatDate() : String {
        val dateInMillis = data.getLong(MainActivity.INDEX_WEATHER_DATE)
        return SunshineDateUtils.getFriendlyDateString(context, dateInMillis, true)
    }

    private fun formatDescription() : String {
        val weatherId = data.getInt(MainActivity.INDEX_WEATHER_CONDITION_ID);
        return SunshineWeatherUtils.getStringForWeatherCondition(context, weatherId);
    }

    private fun formatHighTemp() : String {
        val highInCelsius = data.getDouble(DetailActivity.INDEX_WEATHER_MAX_TEMP);
        return SunshineWeatherUtils.formatTemperature(context, highInCelsius);
    }

    private fun formatLowTemp() : String {
        val lowInCelsius = data.getDouble(DetailActivity.INDEX_WEATHER_MIN_TEMP);
        return SunshineWeatherUtils.formatTemperature(context, lowInCelsius);
    }

    private fun formatWind() : String {
        val windSpeed = data.getFloat(DetailActivity.INDEX_WEATHER_WIND_SPEED);
        val windDirection = data.getFloat(DetailActivity.INDEX_WEATHER_DEGREES);
        return SunshineWeatherUtils.getFormattedWind(context, windSpeed, windDirection);
    }

    private fun formatHumidity() : String {
        val humidity = data.getFloat(DetailActivity.INDEX_WEATHER_HUMIDITY);
        return context.getString(R.string.format_humidity, humidity);
    }

    private fun formatPressure() : String {
        val pressure = data.getFloat(DetailActivity.INDEX_WEATHER_PRESSURE);
        return context.getString(R.string.format_pressure, pressure);
    }

    private fun formatSummary() : String {
        return String.format("%s - %s - %s/%s", date, description, highTemp, lowTemp);
    }
}
