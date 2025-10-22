package com.example.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.R
import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.Weather

class MainViewModel : ViewModel() {
    val weather: Weather


    init{
        //Placeholder data
        weather = Weather(
            current = Current(
                icon = R.drawable.rain_konkapp,
                conditionText = "Raining",
                tempC = 21.0,
                precipType = "Rain",
                precipMm = 1.0,
                windDir = "SW",
                windKph = 31.0
                ),
            forecast = listOf(
                Forecast(
                    date = "Thursday, October 9",
                    icon = R.drawable.sunnyclouds_freepik,
                    maxTempC = 11.0,
                    minTempC = 5.0,
                    conditionText = "Sunny with Clouds",
                    precipType = "Rain",
                    precipMm = 0.3,
                    precipChance = 30,
                    windDir = "NW",
                    windKph = 24.0,
                    humidity = 57
                ),
                Forecast(
                    date = "Friday, October 10",
                    icon = R.drawable.sun_freepik,
                    maxTempC = 12.0,
                    minTempC = 5.0,
                    conditionText = "Sun",
                    precipType = "Rain",
                    precipMm = 0.5,
                    precipChance = 10,
                    windDir = "NE",
                    windKph = 30.0,
                    humidity = 47
                ),
                Forecast(
                    date = "Saturday, October 11",
                    icon = R.drawable.sunnyclouds_freepik,
                    maxTempC = 17.0,
                    minTempC = 7.0,
                    conditionText = "Sunny with Clouds",
                    precipType = "Rain",
                    precipMm = 3.3,
                    precipChance = 10,
                    windDir = "W",
                    windKph = 15.0,
                    humidity = 48
                ),
                Forecast(
                    date = "Sunday, October 12",
                    icon = R.drawable.sunnyrain_freepik,
                    maxTempC = 17.0,
                    minTempC = 4.0,
                    conditionText = "Raining with Sun",
                    precipType = "Rain",
                    precipMm = 0.6,
                    precipChance = 60,
                    windDir = "S",
                    windKph = 43.0,
                    humidity = 70
                ),
                Forecast(
                    date = "Monday, October 13",
                    icon = R.drawable.snowing_freepik,
                    maxTempC = 9.0,
                    minTempC = 0.0,
                    conditionText = "Snowing",
                    precipType = "Snow",
                    precipMm = 0.4,
                    precipChance = 70,
                    windDir = "SE",
                    windKph = 15.0,
                    humidity = 38
                ),
                Forecast(
                    date = "Tuesday, October 14",
                    icon = R.drawable.thunderstorm_konkapp,
                    maxTempC = 12.0,
                    minTempC = 6.0,
                    conditionText = "Thunderstorm",
                    precipType = "Rain",
                    precipMm = 3.8,
                    precipChance = 58,
                    windDir = "NE",
                    windKph = 43.0,
                    humidity = 65
                ),
                Forecast(
                    date = "Wednesday, October 15",
                    icon = R.drawable.sun_freepik,
                    maxTempC = 19.0,
                    minTempC = 9.0,
                    conditionText = "Sun",
                    precipType = "Rain",
                    precipMm = 0.6,
                    precipChance = 30,
                    windDir = "E",
                    windKph = 30.0,
                    humidity = 49
                ),
            )
        )

    }
}