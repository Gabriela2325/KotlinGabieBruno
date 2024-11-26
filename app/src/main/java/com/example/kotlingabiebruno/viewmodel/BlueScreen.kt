//package com.example.kotlingabiebruno.viewmodel
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.navigation.NavController
//import com.example.kotlingabiebruno.database.DatabaseBuilder
//import com.example.kotlingabiebruno.model.Livro
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//@Composable
//fun BlueScreen(navController: NavController) {
//    val context = androidx.compose.ui.platform.LocalContext.current
//    val livroDao = DatabaseBuilder.getInstance(context).livroDao()
//    var livros by remember { mutableStateOf(emptyList<Livro>()) }
//    var livroSelecionado by remember { mutableStateOf<Map<String, String>?>(null) }
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
//            ButtonBar(navController = navController, currentScreen = "blue")
//
//            // Título da página
//            Text(
//                text = "Modificar Livro",
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 16.dp)
//                    .align(Alignment.CenterHorizontally),
//                color = Color.Black
//            )
//
//            if (livroSelecionado == null) {
//                // Dropdown para selecionar o livro
//                LivroSelector(livros = livros, onLivroSelecionado = { livroSelecionado = it })
//            } else {
//                // Formulário para editar o livro
//                EditarLivroForm(
//                    livro = livroSelecionado!!,
//                    onCancelar = { livroSelecionado = null },
//                    onSalvar = { livro ->
//                        CoroutineScope(Dispatchers.IO).launch {
//                            val livroEntity = mapToLivro(livro, id = livro["id"]?.toInt() ?: 0) // Convertendo Map para Livro
//                            livroDao.update(livroEntity) // Atualiza o livro no banco
//                            livros = livroDao.getAll() // Atualiza a lista de livros
//                            livroSelecionado = null // Reseta o formulário
//                        }
//                    }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun LivroSelector(
//    livros: List<Map<String, String>>,
//    onLivroSelecionado: (Map<String, String>) -> Unit
//) {
//    var expanded by remember { mutableStateOf(false) }
//    var selectedLivro by remember { mutableStateOf<Map<String, String>?>(null) }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text("Selecione um livro:")
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        ) {
//            Text(
//                text = selectedLivro?.get("titulo") ?: "Selecione...", // Se não houver seleção, exibe "Selecione..."
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            livros.forEach { livro ->
//                val tituloLivro = livro["titulo"] ?: "Título não disponível" // Garantindo que sempre haverá um valor
//                DropdownMenuItem(onClick = {
//                    selectedLivro = livro
//                    onLivroSelecionado(livro)
//                    expanded = false // Fecha o dropdown após a seleção
//                }) {
//                    Text(tituloLivro) // Usando um valor não nulo para o texto
//                }
//            }
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = { expanded = true }) {
//            Text("Selecionar")
//        }
//    }
//}
//
//fun DropdownMenuItem(onClick: () -> Unit, interactionSource: @Composable () -> Unit) {
//    TODO("Not yet implemented")
//}
//
//
//@Composable
//fun EditarLivroForm(
//    livro: Map<String, String>,
//    onCancelar: () -> Unit,
//    onSalvar: (Map<String, String>) -> Unit
//) {
//    var titulo by remember { mutableStateOf(livro["titulo"] ?: "") }
//    var autor by remember { mutableStateOf(livro["autor"] ?: "") }
//    var genero by remember { mutableStateOf(livro["genero"] ?: "") }
//    var statusLeitura by remember { mutableStateOf(livro["statusLeitura"] ?: "") }
//    var anotacoes by remember { mutableStateOf(livro["anotacoes"] ?: "") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        // Campos de formulário
//        Text("Título")
//        BasicTextField(
//            value = titulo,
//            onValueChange = { titulo = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        Text("Autor")
//        BasicTextField(
//            value = autor,
//            onValueChange = { autor = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        Text("Gênero")
//        BasicTextField(
//            value = genero,
//            onValueChange = { genero = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        Text("Status de Leitura")
//        BasicTextField(
//            value = statusLeitura,
//            onValueChange = { statusLeitura = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.White, RoundedCornerShape(8.dp))
//                .padding(8.dp)
//        )
//
//        Text("Anotações")
//        BasicTextField(
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
//                onClick = onCancelar,
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
//                modifier = Modifier.weight(1f)
//            ) {
//                Text("Cancelar")
//            }
//
//            Button(
//                onClick = {
//                    onSalvar(
//                        livro.toMutableMap().apply {
//                            put("titulo", titulo)
//                            put("autor", autor)
//                            put("genero", genero)
//                            put("statusLeitura", statusLeitura)
//                            put("anotacoes", anotacoes)
//                        }
//                    )
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
//// Função para converter Map para Livro
//fun mapToLivro(livro: Map<String, String>, id: Int): Livro {
//    return Livro(
//        id = id,
//        titulo = livro["titulo"] ?: "",
//        autor = livro["autor"] ?: "",
//        genero = livro["genero"] ?: "",
//        statusLeitura = livro["statusLeitura"] ?: "",
//        anotacoes = livro["anotacoes"] ?: ""
//    )
//}
//
