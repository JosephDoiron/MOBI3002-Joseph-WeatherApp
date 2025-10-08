package com.example.weatherapp.ui.theme.screens

import com.example.weatherapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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

@Composable
fun DailyForecastScreen(
) {
    BackgroundImage()

        // Content column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Middle placeholder (for later, e.g., list of daily temps)
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "Monday: 22\u00B0 Cloudy",
                    fontSize = 36.sp,
                    color = Color.White,
                    modifier = Modifier.background(Color.Black.copy(alpha = 0.25f))
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "Tuesday: 23\u00B0 Sunny",
                    fontSize = 36.sp,
                    color = Color.White,
                    modifier = Modifier.background(Color.Black.copy(alpha = 0.25f))
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "Wednesday 19\u00B0 Rain",
                    fontSize = 36.sp,
                    color = Color.White,
                    modifier = Modifier.background(Color.Black.copy(alpha = 0.25f))
                )
            }
        }
    }
