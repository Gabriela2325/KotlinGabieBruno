package com.example.kotlingabiebruno.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlingabiebruno.model.Livro
import com.example.kotlingabiebruno.repository.LivroRepository
import kotlinx.coroutines.launch

class LivroViewModel(context: Context) : ViewModel() {

    private val repository = LivroRepository(context)

//    // LiveData para armazenar e observar a lista de livros
//    private val _livros = MutableLiveData<List<Livro>>()
//    val livros: LiveData<List<Livro>> get() = _livros
//
//    // Função para buscar todos os livros
//    fun getAllLivros() {
//        viewModelScope.launch {
//            val livrosList = repository.getAllLivros()
//            _livros.postValue(livrosList)
//        }
//    }
//
//    // Função para adicionar um livro
//    fun addLivro(livro: Livro) {
//        viewModelScope.launch {
//            repository.insertLivro(livro)
//            getAllLivros() // Atualiza a lista de livros após a inserção
//        }
//    }
//
//    // Função para atualizar um livro
//    fun updateLivro(livro: Livro) {
//        viewModelScope.launch {
//            repository.updateLivro(livro)
//            getAllLivros() // Atualiza a lista de livros após a atualização
//        }
//    }
//
//    // Função para excluir um livro
//    fun deleteLivro(livro: Livro) {
//        viewModelScope.launch {
//            repository.deleteLivro(livro)
//            getAllLivros() // Atualiza a lista de livros após a exclusão
//        }
//    }
}
