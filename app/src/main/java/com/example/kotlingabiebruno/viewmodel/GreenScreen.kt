package com.example.kotlingabiebruno.viewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlingabiebruno.database.DatabaseBuilder

@Composable
fun GreenScreen(navController: NavController) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val livroDao = DatabaseBuilder.getInstance(context).livroDao()
    var livros by remember { mutableStateOf(emptyList<Map<String, String>>()) }

    LaunchedEffect(Unit) {
        livros = livroDao.getAll() // Carregar os livros
    }

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF5F5F5)) { // Cinza claro
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            // Barra de navegação
            ButtonBar(navController = navController, currentScreen = "green")

            // Título da página
            Text(
                text = "Listar Livros",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.Black
            )

            // Lista de livros
            LivroList(livros)
        }
    }
}

@Composable
fun LivroList(livros: List<Map<String, String>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(livros) { livro ->
            LivroItem(livro)
        }
    }
}

@Composable
fun LivroItem(livro: Map<String, String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, MaterialTheme.shapes.medium)
            .padding(16.dp)
    ) {
        Text(
            text = livro["titulo"] ?: "Título não disponível", // Verifica se o título está presente
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Autor: ${livro["autor"] ?: "Autor não disponível"}",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
        Text(
            text = "Gênero: ${livro["genero"] ?: "Gênero não disponível"}",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
        Text(
            text = "Status: ${livro["statusLeitura"] ?: "Status não disponível"}",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
        Text(
            text = "Anotações: ${livro["anotacoes"] ?: "Anotações não disponíveis"}",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}
