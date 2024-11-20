package com.example.kotlingabiebruno.viewmodel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun GreenScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
        Button(onClick = { navController.navigate("red") }) {
            Text(text = "Go to Red")
        }
    }
}