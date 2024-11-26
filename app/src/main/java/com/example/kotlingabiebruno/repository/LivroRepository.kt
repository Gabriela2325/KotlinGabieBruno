package com.example.kotlingabiebruno.repository

import android.content.Context
import com.example.kotlingabiebruno.database.DatabaseBuilder
import com.example.kotlingabiebruno.model.Livro

class LivroRepository(context: Context) {
    private val livroDao = DatabaseBuilder.getInstance(context).livroDao()

//    // Função para buscar todos os livros
//    suspend fun getAllLivros(): List<Livro> = livroDao.getAll()
//
//    // Função para inserir um livro
//    suspend fun insertLivro(livro: Livro) {
//        livroDao.insert(livro)
//    }
//
//    // Função para atualizar um livro
//    suspend fun updateLivro(livro: Livro) {
//        livroDao.update(livro)
//    }
//
//    // Função para excluir um livro
//    suspend fun deleteLivro(livro: Livro) {
//        livroDao.delete(livro)
//    }
}
