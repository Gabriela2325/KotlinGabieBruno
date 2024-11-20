package com.example.kotlingabiebruno.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.kotlingabiebruno.model.Livro
import com.example.kotlingabiebruno.repository.LivroRepository

class LivroViewModel(context: Context) : ViewModel() {
    private val repository = LivroRepository(context)

    suspend  fun getAllLivros() = repository.getAllLivros()



    suspend  fun addLivro(livro: Livro) = repository.insertLivro(livro)
    suspend  fun updateLivro(livro: Livro) = repository.updateLivro(livro)
    suspend  fun deleteLivro(livro: Livro) = repository.deleteLivro(livro)
}
