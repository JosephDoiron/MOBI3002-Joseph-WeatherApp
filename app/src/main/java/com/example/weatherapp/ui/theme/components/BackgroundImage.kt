package com.example.weatherapp.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.R

@Composable
fun BackgroundImage(  //Idea: Have function that looks at condition then sets background image to sunny, cloudy, or rain, or night.
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.sunclouds,
    alpha: Float = 0.75f
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer { this.alpha = alpha },
            contentScale = ContentScale.Crop
        )
    }
}
