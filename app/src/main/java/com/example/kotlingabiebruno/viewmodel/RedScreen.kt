//package com.example.kotlingabiebruno.viewmodel
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.TextField
//import androidx.compose.ui.platform.LocalContext
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.example.kotlingabiebruno.database.DatabaseBuilder
//import com.example.kotlingabiebruno.database.migration.model.Livro
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//@Composable
//fun RedScreen(navController: NavController) {
//    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF5F5F5)) { // Cinza claro
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .statusBarsPadding() // Garante que os elementos respeitem o recorte da câmera
//        ) {
//            // Barra de navegação
//            ButtonBar(navController = navController, currentScreen = "red")
//
//            // Título da página
//            Text(
//                text = "Adicionar novo livro",
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp, // Tamanho da fonte aumentado
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 16.dp)
//                    .align(Alignment.CenterHorizontally), // Centraliza o texto horizontalmente
//                color = Color.Black
//            )
//
//            // Formulário de inserção
//            FormularioInserirLivro(navController)
//        }
//    }
//}
//
//@Composable
//fun ButtonBar(navController: NavController, currentScreen: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFEEEEEE)) // Tom de cinza para a barra
//            .padding(8.dp),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//        Button(
//            onClick = { navController.navigate("red") },
//            enabled = currentScreen != "red", // Desabilita o botão se estiver na tela atual
//            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Gray)
//        ) {
//            Text("Novo")
//        }
//
//        Button(
//            onClick = { navController.navigate("blue") },
//            enabled = currentScreen != "blue",
//            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Gray)
//        ) {
//            Text("Modificar")
//        }
//
//        Button(
//            onClick = { navController.navigate("green") },
//            enabled = currentScreen != "green",
//            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Gray)
//        ) {
//            Text("Listar")
//        }
//    }
//}
//
//@Composable
//fun FormularioInserirLivro(navController: NavController) {
//    val context = LocalContext.current
//    val livroViewModel: LivroViewModel = viewModel() // Obtém o ViewModel
//
//    var titulo by remember { mutableStateOf("") }
//    var autor by remember { mutableStateOf("") }
//    var genero by remember { mutableStateOf("") }
//    var statusLeitura by remember { mutableStateOf("") }
//    var anotacoes by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        // Campos do formulário
//        Text("Título")
//        TextField(
//            value = titulo,
//            onValueChange = { titulo = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        Text("Autor")
//        TextField(
//            value = autor,
//            onValueChange = { autor = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        Text("Gênero")
//        TextField(
//            value = genero,
//            onValueChange = { genero = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        Text("Status de Leitura")
//        TextField(
//            value = statusLeitura,
//            onValueChange = { statusLeitura = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        Text("Anotações")
//        TextField(
//            value = anotacoes,
//            onValueChange = { anotacoes = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        // Botões
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            Button(
//                onClick = { navController.navigate("red") }, // Cancela e volta para a mesma tela
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
//                modifier = Modifier.weight(1f)
//            ) {
//                Text("Cancelar")
//            }
//
//            Button(
//                onClick = {
//                    // Lógica para inserir livro no banco, agora usando o ViewModel
//                    val novoLivro = Livro(
//                        titulo = titulo,
//                        autor = autor,
//                        genero = genero,
//                        statusLeitura = statusLeitura,
//                        anotacoes = anotacoes
//                    )
//
////                    CoroutineScope(Dispatchers.IO).launch {
////                        livroViewModel.addLivro()// Inserir através do ViewModel
////                        navController.navigate("green") // Volta para a tela de listagem
////                    }
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
//                modifier = Modifier.weight(1f)
//            ) {
//                Text("OK")
//            }
//        }
//    }
//}
//
