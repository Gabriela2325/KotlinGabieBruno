package com.example.kotlingabiebruno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlingabiebruno.ui.theme.KotlinGabieBrunoTheme
import com.example.kotlingabiebruno.viewmodel.BlueScreen
import com.example.kotlingabiebruno.viewmodel.GreenScreen
import com.example.kotlingabiebruno.viewmodel.RedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinGabieBrunoTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Define a navegação entre as telas
    NavHost(navController = navController, startDestination = "red") {
        composable("red") { RedScreen(navController) }
        composable("blue") { BlueScreen(navController) }
        composable("green") { GreenScreen(navController) }
    }
}
