package com.example.kotlingabiebruno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlingabiebruno.database.DatabaseBuilder
import com.example.kotlingabiebruno.model.Livro
import com.example.kotlingabiebruno.ui.theme.KotlinGabieBrunoTheme
import com.example.kotlingabiebruno.viewmodel.BlueScreen
import com.example.kotlingabiebruno.viewmodel.GreenScreen
import com.example.kotlingabiebruno.viewmodel.RedScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinGabieBrunoTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    val livros = remember { mutableStateListOf<Livro>() }
//
//                    // Inserir livros e carregar lista
//                    LaunchedEffect(Unit) {
//                        CoroutineScope(Dispatchers.IO).launch {
//                            val livroDao = DatabaseBuilder.getInstance(applicationContext).livroDao()
//
//                            // Inserir alguns livros no banco de dados
////                            livroDao.insert(Livro(titulo = "asdasf", autor = "asdsadas Orwell", genero = "fatdsfdsa", statusLeitura = "lendo", anotacoes = "anotado"))
////                            livroDao.insert(Livro(titulo = "O Senhor dos Anéis", autor = "J.R.R. Tolkien", genero = "fata", statusLeitura = "lendo", anotacoes = "anotado"))
////                            livroDao.insert(Livro(titulo = "Dom Quixote", autor = "Miguel de Cervantes", genero = "fata", statusLeitura = "lendo", anotacoes = "anotado"))
//
//                            // Buscar todos os livros e atualizar a lista
//                            val livroList = livroDao.getAll()
//                            livros.clear()
//                            livros.addAll(livroList)
//                        }
//                    }
//
//                    // Exibir lista de livros , mostrar ao user
//                    LivroList(
//                        livros = livros,
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
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


