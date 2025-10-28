package com.example.weatherapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.example.weatherapp.viewmodel.MainViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource


class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                GetLocation{ coordinates -> mainViewModel.fetchWeather(coordinates)}
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

    val weather by mainViewModel.weather.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.9f),
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    val locationName = weather?.location?.name ?: "Loading..."
                    val region = weather?.location?.region ?: ""
                    val country = weather?.location?.country ?: ""
                    Text(text = buildString{
                        append(locationName)
                    }) //Variable Text Here
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun GetLocation(onLocationFound: (String) -> Unit) {
    // Remember the permission state(asking for Fine location)
    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    if (permissionState.status.isGranted) {
        Log.i("TESTING", "Hurray, permission granted!")

        // Get Location
        val currentContext = LocalContext.current
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(currentContext)

        if (ContextCompat.checkSelfPermission(
                currentContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED)
        {
            val cancellationTokenSource = CancellationTokenSource()

            Log.i("TESTING", "Requesting location...")

            fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, cancellationTokenSource.token)
                .addOnSuccessListener { location ->
                    if (location != null) {
                        val lat = location.latitude.toString()
                        val lng = location.longitude.toString()

                        Log.i("TESTING", "Success: $lat $lng")

                        val coordinates = "$lat,$lng"

                        // call a function, like in View Model, to do something with location...
                        // 👇 Call the callback and send the coordinates
                        onLocationFound(coordinates)
                    }
                    else {
                        Log.i("TESTING", "Problem encountered: Location returned null")
                    }
                }
        }
    }
    else {
        // Run a side-effect (coroutine) to get permission. The permission popup.
        LaunchedEffect(permissionState){
            permissionState.launchPermissionRequest()
        }
    }
}
