//package com.example.kotlingabiebruno
//
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.kotlingabiebruno.viewmodel.GreenScreen
import com.example.kotlingabiebruno.viewmodel.BlueScreen
import com.example.kotlingabiebruno.viewmodel.RedScreen



//import android.os.Bundle
//import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlingabiebruno.ui.theme.KotlinGabieBrunoTheme
import com.example.kotlingabiebruno.viewmodel.BlueScreen
import com.example.kotlingabiebruno.viewmodel.GreenScreen
import com.example.kotlingabiebruno.viewmodel.RedScreen
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            KotlinGabieBrunoTheme {
//                // Passando a navegação para a tela
//                Surface {
//                    AppNavigation()
//                }
//            }
//        }
//    }
//}

//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//
//    // Define a navegação entre as telas
//    NavHost(navController = navController, startDestination = "red") {
//        composable("red") { RedScreen(navController) }
//        composable("blue") { BlueScreen(navController) }
//        composable("green") { GreenScreen(navController) }
//    }
//}

//package com.example.kotlingabiebruno
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import com.example.kotlingabiebruno.ui.theme.KotlinGabieBrunoTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            KotlinGabieBrunoTheme {
//                HelloWorldScreen()
//            }
//        }
//    }
//}
//
//@Composable
//fun HelloWorldScreen() {
//    // Simple Hello World text displayed on the screen
//    Text(text = "Hello World!")
//}



//
//@Composable
//fun AppNavigation() {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "green") {
//        composable("green") { GreenScreen(navController) }
//        composable("blue") { BlueScreen(navController) }
//        composable("red") { RedScreen(navController) }
//    }
//}
//
//@Composable
//@Preview(showBackground = true)
//fun DefaultPreview() {
//    MaterialTheme {
//        Surface {
//            AppNavigation()
//        }
//    }
//}


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlingabiebruno.database.DatabaseBuilder
import com.example.kotlingabiebruno.model.Livro
import com.example.kotlingabiebruno.ui.theme.KotlinGabieBrunoTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinGabieBrunoTheme {
                Surface {
                    LivroApp()
                }
            }
        }
    }
}

// Função principal que coordena a adição e exibição do livro
@Composable
fun LivroApp() {
    addLivro()
    LivroScreen()
}

// Função para adicionar o livro ao banco de dados
@Composable
fun addLivro() {
    val context = LocalContext.current // Obtém o contexto corretamente
    val livro = Livro(
        titulo = "Aprendendo Kotlin",
        autor = "Mauricio",
        genero = "Terror",
        statusLeitura = "Lendo",
        anotacoes = "Aterroizado"
    )

    // Adicionar livro na thread de background
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val dao = DatabaseBuilder.getInstance(context).livroDao()
            dao.insert(livro)
        }
    }
}

@Composable
fun LivroScreen() {
    val context = LocalContext.current // Obtém o contexto corretamente

    // Obter livro do banco de dados
    val livro = remember { mutableStateOf<Livro?>(null) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val dao = DatabaseBuilder.getInstance(context).livroDao()
            livro.value = dao.getAll().firstOrNull() // Pega o primeiro livro do banco
        }
    }

    // Exibir as informações do livro
    livro.value?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Título: ${it.titulo}")
            Text(text = "Autor: ${it.autor}")
            Text(text = "Gênero: ${it.genero}")
            Text(text = "Status: ${it.statusLeitura}")
            Text(text = "Anotações: ${it.anotacoes}")
        }
    }
}
