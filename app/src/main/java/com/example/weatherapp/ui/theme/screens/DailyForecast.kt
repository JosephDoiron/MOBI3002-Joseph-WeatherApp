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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.ForecastDay
import com.example.weatherapp.ui.theme.components.BackgroundImage
import com.example.weatherapp.viewmodel.MainViewModel

@Composable
fun DailyForecastScreen(mainViewModel: MainViewModel) {
    val weather by mainViewModel.weather.collectAsState()
    val forecastList = mainViewModel.weather.collectAsState().value?.forecast?.forecastDay ?: emptyList()    //val forecastList = mainViewModel.weather.forecast

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
            items(forecastList) { forecastDay ->
                ForecastRow(forecastDay)
            }
        }

    }
    }

@Composable
fun ForecastRow(forecastDay: ForecastDay) {
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
                painter = rememberAsyncImagePainter(forecastDay.day.condition.icon),
                contentDescription = forecastDay.day.condition.text,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )

            Column {
                Text(
                    text = forecastDay.date,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = forecastDay.day.condition.text,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Precip: ${forecastDay.day.precipMm}mm (${forecastDay.day.rainChance}%)",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
                Text(
                    text = "Wind: ${forecastDay.day.windKph} km/h ${forecastDay.day.hour.windDir}",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
                Text(
                    text = "Humidity: ${forecastDay.day.hour.humidity}%",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )

            }
        }

        // Right: temperatures
        Text(
            text = "${forecastDay.day.maxTempC}\u00B0C / ${forecastDay.day.minTempC}\u00B0C",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}
