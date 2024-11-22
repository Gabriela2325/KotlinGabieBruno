package com.example.kotlingabiebruno.viewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.navigation.NavController
import com.example.kotlingabiebruno.database.DatabaseBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun RedScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF5F5F5)) { // Cinza claro
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding() // Garante que os elementos respeitem o recorte da câmera
        ) {
            // Barra de navegação
            ButtonBar(navController = navController, currentScreen = "red")

            // Título da página
            Text(
                text = "Adicionar novo livro",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp, // Tamanho da fonte aumentado
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterHorizontally), // Centraliza o texto horizontalmente
                color = Color.Black
            )

            // Formulário de inserção
            FormularioInserirLivro(navController)
        }
    }
}

@Composable
fun ButtonBar(navController: NavController, currentScreen: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEEEEEE)) // Tom de cinza para a barra
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { navController.navigate("red") },
            enabled = currentScreen != "red", // Desabilita o botão se estiver na tela atual
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text("Novo")
        }

        Button(
            onClick = { navController.navigate("blue") },
            enabled = currentScreen != "blue",
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text("Modificar")
        }

        Button(
            onClick = { navController.navigate("green") },
            enabled = currentScreen != "green",
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text("Listar")
        }
    }
}

@Composable
fun FormularioInserirLivro(navController: NavController) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val livroDao = DatabaseBuilder.getInstance(context).livroDao()

    var titulo by remember { mutableStateOf("") }
    var autor by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var statusLeitura by remember { mutableStateOf("") }
    var anotacoes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Campos do formulário
        Text("Título")
        TextField(
            value = titulo,
            onValueChange = { newValue -> titulo = newValue },  // Use `newValue` ao invés de `it`
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Text("Autor")
        TextField(
            value = autor,
            onValueChange = { newValue -> autor = newValue },  // Use `newValue` ao invés de `it`
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Text("Gênero")
        TextField(
            value = genero,
            onValueChange = { newValue -> genero = newValue },  // Use `newValue` ao invés de `it`
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Text("Status de Leitura")
        TextField(
            value = statusLeitura,
            onValueChange = { newValue -> statusLeitura = newValue },  // Use `newValue` ao invés de `it`
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Text("Anotações")
        TextField(
            value = anotacoes,
            onValueChange = { newValue -> anotacoes = newValue },  // Use `newValue` ao invés de `it`
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        // Botões
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { navController.navigate("red") }, // Cancela e volta para a mesma tela
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Gray),
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancelar")
            }

            Button(
                onClick = {
                    // Lógica para inserir livro no banco, agora usando Map<String, String>
                    CoroutineScope(Dispatchers.IO).launch {
                        val novoLivro = mapOf(
                            "titulo" to titulo,
                            "autor" to autor,
                            "genero" to genero,
                            "statusLeitura" to statusLeitura,
                            "anotacoes" to anotacoes
                        )
                        livroDao.insert(novoLivro) // Inserir usando Map
                        navController.navigate("green") // Volta para a tela de listagem
                    }
                },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Gray),
                modifier = Modifier.weight(1f)
            ) {
                Text("OK")
            }
        }
    }
}
