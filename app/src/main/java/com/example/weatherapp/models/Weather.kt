package com.example.weatherapp.models

import com.example.weatherapp.R

data class Weather(
    val current: Current,
    val forecast: List<Forecast>
)

data class Current(
    val icon: Int,
    val conditionText: String,
    val tempC: Double,
    val precipType: String,
    val precipMm: Double,
    val windDir: String,
    val windKph: Double
)

data class Forecast(
    val date: String,
    val icon: Int,
    val maxTempC: Double,
    val minTempC: Double,
    val conditionText: String,
    val precipType: String,
    val precipMm: Double,
    val precipChance: Int,
    val windDir: String,
    val windKph: Double,
    val humidity: Int
)
