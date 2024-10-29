package com.example.cleanarchitecturetemplate.presenation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecturetemplate.common.Constants
import com.example.cleanarchitecturetemplate.presenation.coin_detail_screen.CoinDetailScreen
import com.example.cleanarchitecturetemplate.presenation.coin_list_screen.CoinListScreen
import com.example.cleanarchitecturetemplate.presenation.ui.theme.CleanArchitectureTemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable (
            route = Screen.CoinListScreen.route
        ) { 
            CoinListScreen(navController = navController)
        }
        composable (
            route = Screen.CoinDetailScreen.route + "/{${Constants.PARAM_COIN_ID}}"
        ) {
            CoinDetailScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchitectureTemplateTheme {
        App()
    }
}