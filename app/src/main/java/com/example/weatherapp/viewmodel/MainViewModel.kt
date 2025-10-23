package com.example.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.R
import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.Weather
import com.example.weatherapp.services.WeatherService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

    private val apiKey = "26fdcf2c0b52405eac0153403252310"

    // Retrofit setup
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(WeatherService::class.java)

    init {
        fetchWeather()  // fetch default location on startup
    }


    fun fetchWeather(location: String = "B4C1G2") {
        viewModelScope.launch {
            try {
                val response: Weather = service.getWeather(
                    apiKey = apiKey,
                    location = location,
                    days = 7
                )
                _weather.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                _weather.value = null
            }
        }
    }
}


