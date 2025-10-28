package com.example.weatherapp.ui.theme.screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DailyForecastScreen(mainViewModel: MainViewModel) {
    val weather by mainViewModel.weather.collectAsState()
    val forecastList = weather?.forecast?.forecastDay ?: emptyList()


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
    val displayHour = forecastDay.day.hour?.firstOrNull()


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter("https:" + forecastDay.day.condition.icon),
                contentDescription = forecastDay.day.condition.text,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )

            Column {
                Text(forecastDay.date, color = Color.White, fontSize = 20.sp)
                Text(forecastDay.day.condition.text,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 16.sp)
                Spacer(Modifier.height(4.dp))
                Text("Precip: ${forecastDay.day.precipMm}mm (${forecastDay.day.rainChance}%)",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp)
                Text("Wind: ${forecastDay.day.windKph} km/h ${displayHour?.windDir ?: "N/A"}",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp)
                Text("Humidity: ${displayHour?.humidity ?: "N/A"}%",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp)
            }
        }

        Text("${forecastDay.day.maxTempC}\u00B0C / ${forecastDay.day.minTempC}\u00B0C",
            color = Color.White,
            fontSize = 20.sp)
    }
}