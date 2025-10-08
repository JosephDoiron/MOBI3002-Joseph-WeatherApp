package com.example.weatherapp.models

import android.health.connect.datatypes.units.Temperature

data class Weather(
    val current: Current,
    val forecast: List<Forecast>
)

data class Current(
    val image: Int,
    val condition: String,
    val temperature: Double,
    val precipType: String,
    val precipAmount: Double,
    val windDirect: String,
    val windSpeed: Double
)

data class Forecast(
    val date: String,
    val image: Int,
    val tempHigh: Double,
    val tempLow: Double,
    val condition: String,
    val precipType: String,
    val precipAmount: Double,
    val precipProb: Int,
    val windDirect: String,
    val windSpeed: Double,
    val humidity: Int
)