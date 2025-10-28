package com.example.weatherapp.ui.theme.screens

import com.example.weatherapp.R
import android.content.Intent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import coil.compose.AsyncImage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.models.Condition
import com.example.weatherapp.ui.theme.components.BackgroundImage
import com.example.weatherapp.viewmodel.MainViewModel


@Composable
fun CurrentWeatherScreen(mainViewModel: MainViewModel) {
    val weather by mainViewModel.weather.collectAsState()

    BackgroundImage()

    weather?.let { currentWeather ->
        val current = currentWeather.current
        val location = currentWeather.location

        Column(
            modifier = Modifier
                .fillMaxSize()               // fill the screen so centering works
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Black.copy(alpha = 0.50f))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${current.tempC}\u00B0C",
                        fontSize = 90.sp,
                        color = Color.White
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(
                            text = current.condition.text,
                            fontSize = 28.sp,
                            color = Color.White
                        )

                        Image(
                            painter = rememberAsyncImagePainter("https:" + current.condition.icon),
                            contentDescription = current.condition.text,
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(64.dp)       // give the image a visible size
                        )
                    }

                    Text(
                        text = "Precipitation: ${current.precipMm} mm",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Text(
                        text = "Wind: ${current.windKph} KM/h ${current.windDir}",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
            }
        }
    }
}
