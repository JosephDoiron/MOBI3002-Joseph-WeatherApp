package com.example.weatherapp.models

import com.example.weatherapp.R
import com.google.gson.annotations.SerializedName

data class Weather(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Location(
    val name: String,
    val country: String,
    val localtime: String
)


data class Current(
    @SerializedName("last_updated")
    val lastUpdated: String,

    @SerializedName("temp_c")
    val tempC: Double,

    val condition: Condition,

    @SerializedName("wind_kph")
    val windKph: Double,

    @SerializedName("wind_dir")
    val windDir: String,

    val humidity: Int,

    @SerializedName("precip_mm")
    val precipMm: Double,

    @SerializedName("feelslike_c")
    val feelslikeC: Double
)

data class Forecast(
    @SerializedName("forecastday")
    val forecastDay: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val day: Day,
//    val hour: List<Hour>
)

data class Day(
    @SerializedName("maxtemp_c")
    val maxTempC: Double,

    @SerializedName("mintemp_c")
    val minTempC: Double,

    @SerializedName("avgtemp_c")
    val avgTempC: Double,

    val condition: Condition,

    @SerializedName("daily_chance_of_rain")
    val rainChance: Int,

    @SerializedName("totalprecip_mm")
    val precipMm: Double,

    @SerializedName("maxwind_kph")
    val windKph: Double,

    val hour: Hour
)

data class Hour(
    @SerializedName("wind_dir")
    val windDir: String,

    val humidity: Int
)

data class Condition(
    @SerializedName("text")val text: String,
    val icon: String
)