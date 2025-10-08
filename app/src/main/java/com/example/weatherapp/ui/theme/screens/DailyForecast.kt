package com.example.weatherapp.ui.theme.screens

import com.example.weatherapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.ui.theme.components.BackgroundImage
import com.example.weatherapp.viewmodel.MainViewModel

@Composable
fun DailyForecastScreen(mainViewModel: MainViewModel) {
    val forecastList = mainViewModel.weather.forecast

    BackgroundImage()

        // Content column
    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        LazyColumn(
           modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.spacedBy(24.dp),
           horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(forecastList) { forecast ->
                ForecastRow(forecast)
            }
        }

    }
    }

@Composable
fun ForecastRow(forecast: Forecast) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left: icon + date + condition + extra info
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = forecast.image),
                contentDescription = forecast.condition,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )

            Column {
                Text(
                    text = forecast.date,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = forecast.condition,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Precip: ${forecast.precipAmount}mm (${forecast.precipProb}%) ${forecast.precipType}",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
                Text(
                    text = "Wind: ${forecast.windSpeed} km/h ${forecast.windDirect}",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
                Text(
                    text = "Humidity: ${forecast.humidity}%",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }
        }

        // Right: temperatures
        Text(
            text = "${forecast.tempHigh}\u00B0C / ${forecast.tempLow}\u00B0C",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}
