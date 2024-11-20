package com.example.kotlingabiebruno.repository


import android.content.Context
import com.example.kotlingabiebruno.database.DatabaseBuilder
import com.example.kotlingabiebruno.model.Livro

class LivroRepository(context: Context) {
    private val livroDao = DatabaseBuilder.getInstance(context).livroDao()

    suspend  fun getAllLivros() = livroDao.getAll()
    suspend  fun insertLivro(livro: Livro) = livroDao.insert(livro)
    suspend  fun updateLivro(livro: Livro) = livroDao.atualizarLivro(livro)
    suspend  fun deleteLivro(livro: Livro) = livroDao.excluirLivro(livro)
}
