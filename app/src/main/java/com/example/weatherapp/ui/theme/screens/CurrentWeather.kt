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
import com.example.weatherapp.ui.theme.components.BackgroundImage
import com.example.weatherapp.viewmodel.MainViewModel


@Composable
fun CurrentWeatherScreen(mainViewModel: MainViewModel) {
    val weather = mainViewModel.weather
    val current = mainViewModel.weather.current

    BackgroundImage()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // This Box groups the temperature and condition together visually
        Box(
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.50f))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "${current.temperature}\u00B0C",
                    fontSize = 90.sp,
                    color = Color.White
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 1.dp)
                ) {
                    Text(
                        text = current.condition,
                        fontSize = 28.sp,
                        color = Color.White
                    )
                    Image(
                        painter = painterResource(id = current.image),
                        contentDescription = current.condition,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .fillMaxWidth(0.13f)
                    )
                }
                Text(
                    text = "Precipitation: ${current.precipType} ${current.precipAmount}",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "Wind: ${current.windSpeed} KM/h ${current.windDirect}",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        }
    }
}