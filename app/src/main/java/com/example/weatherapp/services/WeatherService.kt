package com.example.weatherapp.services

import com.example.weatherapp.models.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    //API Key: 26fdcf2c0b52405eac0153403252310
    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int = 7,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): Weather
}