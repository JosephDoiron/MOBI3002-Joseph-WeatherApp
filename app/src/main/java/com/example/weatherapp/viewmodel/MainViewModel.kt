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
                image = R.drawable.rain_konkapp,
                condition = "Raining",
                temperature = 21,
                precipType = "Rain",
                precipAmount = 1.0,
                windDirect = "SW",
                windSpeed = 31
                ),
            forecast = listOf(
                Forecast(
                    date = "Thursday, October 9",
                    image = R.drawable.sunnyclouds_freepik,
                    tempHigh = 11,
                    tempLow = 5,
                    condition = "Sunny with Clouds",
                    precipType = "Rain",
                    precipAmount = 0.3,
                    precipProb = 30,
                    windDirect = "NW",
                    windSpeed = 24,
                    humidity = 57
                ),
                Forecast(
                    date = "Friday, October 10",
                    image = R.drawable.sun_freepik,
                    tempHigh = 12,
                    tempLow = 5,
                    condition = "Sun",
                    precipType = "Rain",
                    precipAmount = 0.5,
                    precipProb = 10,
                    windDirect = "NE",
                    windSpeed = 30,
                    humidity = 47
                ),
                Forecast(
                    date = "Saturday, October 11",
                    image = R.drawable.sunnyclouds_freepik,
                    tempHigh = 17,
                    tempLow = 7,
                    condition = "Sunny with Clouds",
                    precipType = "Rain",
                    precipAmount = 3.3,
                    precipProb = 10,
                    windDirect = "W",
                    windSpeed = 15,
                    humidity = 48
                ),
                Forecast(
                    date = "Sunday, October 12",
                    image = R.drawable.sunnyrain_freepik,
                    tempHigh = 17,
                    tempLow = 4,
                    condition = "Raining with Sun",
                    precipType = "Rain",
                    precipAmount = 0.6,
                    precipProb = 60,
                    windDirect = "S",
                    windSpeed = 43,
                    humidity = 70
                ),
                Forecast(
                    date = "Monday, October 13",
                    image = R.drawable.snowing_freepik,
                    tempHigh = 9,
                    tempLow = 0,
                    condition = "Snowing",
                    precipType = "Snow",
                    precipAmount = 0.4,
                    precipProb = 70,
                    windDirect = "SE",
                    windSpeed = 15,
                    humidity = 38
                ),
                Forecast(
                    date = "Tuesday, October 14",
                    image = R.drawable.thunderstorm_konkapp,
                    tempHigh = 12,
                    tempLow = 6,
                    condition = "Thunderstorm",
                    precipType = "Rain",
                    precipAmount = 3.8,
                    precipProb = 58,
                    windDirect = "NE",
                    windSpeed = 43,
                    humidity = 65
                ),
                Forecast(
                    date = "Wednesday, October 15",
                    image = R.drawable.sun_freepik,
                    tempHigh = 19,
                    tempLow = 9,
                    condition = "Sun",
                    precipType = "Rain",
                    precipAmount = 0.6,
                    precipProb = 30,
                    windDirect = "E",
                    windSpeed = 30,
                    humidity = 49
                ),
            )
        )

    }
}