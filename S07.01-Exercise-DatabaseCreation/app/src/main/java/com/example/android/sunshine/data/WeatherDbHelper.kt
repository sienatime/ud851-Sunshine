/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

/**
 * Manages a local database for weather data.
 */
class WeatherDbHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(context, DATABASE_NAME, null, DATABASE_VERSION)

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""
CREATE TABLE ${WeatherContract.WeatherEntry.TABLE_NAME} (
${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,
${WeatherContract.WeatherEntry.COLUMN_DATE} INTEGER,
${WeatherContract.WeatherEntry.COLUMN_WEATHER_ID} INTEGER,
${WeatherContract.WeatherEntry.COLUMN_MIN_TEMP} REAL,
${WeatherContract.WeatherEntry.COLUMN_MAX_TEMP} REAL,
${WeatherContract.WeatherEntry.COLUMN_HUMIDITY} REAL,
${WeatherContract.WeatherEntry.COLUMN_PRESSURE} REAL,
${WeatherContract.WeatherEntry.COLUMN_WIND_SPEED} REAL,
${WeatherContract.WeatherEntry.COLUMN_DEGREES} REAL)
""")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    companion object {
        const val DATABASE_NAME = "weather.db"
        const val DATABASE_VERSION = 1
    }
}
