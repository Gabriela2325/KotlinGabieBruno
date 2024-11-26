//package com.example.kotlingabiebruno.viewmodel
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.kotlingabiebruno.database.DatabaseBuilder
//import com.example.kotlingabiebruno.model.Livro
//
//@Composable
//fun GreenScreen(navController: NavController) {
//    val context = androidx.compose.ui.platform.LocalContext.current
//    val livroDao = DatabaseBuilder.getInstance(context).livroDao()
//    var livros by remember { mutableStateOf(emptyList<Livro>()) }
//
//    LaunchedEffect(Unit) {
//        livros = livroDao.getAll() // Carregar os livros
//    }
//
//    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF5F5F5)) { // Cinza claro
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .statusBarsPadding()
//        ) {
//            // Barra de navegação
//            ButtonBar(navController = navController, currentScreen = "green")
//
//            // Título da página
//            Text(
//                text = "Listar Livros",
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 16.dp)
//                    .align(Alignment.CenterHorizontally),
//                color = Color.Black
//            )
//
//            // Verificar se há livros e mostrar a lista ou mensagem alternativa
//            if (livros.isEmpty()) {
//                NoBooksMessage()
//            } else {
//                LivroList(livros) // Passando a lista de livros
//            }
//        }
//    }
//}
//
//@Composable
//fun NoBooksMessage() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.Center)
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Nenhum livro encontrado.",
//            fontSize = 18.sp,
//            color = Color.Gray,
//            modifier = Modifier.align(Alignment.Center)
//        )
//    }
//}
//
//// Removendo o tipo genérico e usando List<Livro> diretamente
//@Composable
//fun LivroList(livros: List<Livro>) {
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(livros) { livro ->
//            LivroItem(livro)
//        }
//    }
//}
//
//@Composable
//fun LivroItem(livro: Livro) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.White, MaterialTheme.shapes.medium)
//            .padding(16.dp)
//    ) {
//        Text(
//            text = livro.titulo ?: "Título não disponível", // Acessa a propriedade 'titulo'
//            fontWeight = FontWeight.Bold,
//            fontSize = 18.sp,
//            color = Color.Black
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(
//            text = "Autor: ${livro.autor ?: "Autor não disponível"}",
//            fontSize = 14.sp,
//            color = Color.DarkGray
//        )
//        Text(
//            text = "Gênero: ${livro.genero ?: "Gênero não disponível"}",
//            fontSize = 14.sp,
//            color = Color.DarkGray
//        )
//        Text(
//            text = "Status: ${livro.statusLeitura ?: "Status não disponível"}",
//            fontSize = 14.sp,
//            color = Color.DarkGray
//        )
//        Text(
//            text = "Anotações: ${livro.anotacoes ?: "Anotações não disponíveis"}",
//            fontSize = 14.sp,
//            color = Color.DarkGray
//        )
//    }
//}

package com.example.kotlingabiebruno.viewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GreenScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Tela Verde", color = Color.White, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("blue") }) {
                Text(text = "Ir para a Tela Azul")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { navController.navigate("red") }) {
                Text(text = "Ir para a Tela Vermelha")
            }
        }
    }
}


