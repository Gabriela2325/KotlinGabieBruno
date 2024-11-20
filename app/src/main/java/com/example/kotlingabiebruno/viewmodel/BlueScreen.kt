package com.example.kotlingabiebruno.viewmodel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.kotlingabiebruno.model.Livro

@Composable
fun BlueScreen(navController: NavController) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Blue) {
        Button(onClick = { navController.navigate("green") }) {
            Text(text = "Go to Green")
        }
    }
}

