package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.theme.screens.CurrentWeatherScreen
import com.example.weatherapp.ui.theme.screens.DailyForecastScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.activity.viewModels
import com.example.weatherapp.viewmodel.MainViewModel


class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                DisplayUI(mainViewModel)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayUI(mainViewModel: MainViewModel) {

    val navController = rememberNavController()

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.9f),
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text("Halifax, Nova Scotia") //Variable Text Here
                }

            )

        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.8f),
                contentColor = MaterialTheme.colorScheme.primary
            )
            {
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_weather),
                            contentDescription = "Current Weather"
                        )
                    },
                    label = {
                        Text("Current Weather")
                    },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(route = "currentWeather")
                    }
                )

                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_forecast),
                            contentDescription = "Daily Forecast"
                        )
                    },
                    label = {
                        Text("Daily Forecast")
                    },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(route = "dailyForecast")
                    }
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "currentWeather",
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(route = "currentWeather") {
                CurrentWeatherScreen(mainViewModel)
            }

            composable(route = "dailyForecast"){
                DailyForecastScreen(mainViewModel)
            }

        }
    }

}