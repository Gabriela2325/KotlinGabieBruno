package com.example.kotlingabiebruno.repository

import android.content.Context
import com.example.kotlingabiebruno.database.DatabaseBuilder
import com.example.kotlingabiebruno.database.migration.model.Livro

class LivroRepository(context: Context) {
    private val livroDao = DatabaseBuilder.getInstance(context).livroDao()

    // Função para buscar todos os livros
    suspend fun getAllLivros(): List<Map<String, String>> = livroDao.getAll() // Retorna lista de Map

    // Função para inserir um livro
    suspend fun insertLivro(livro: Livro) = livroDao.insert(livro) // Inserção com Map

    // Função para atualizar um livro
    suspend fun updateLivro(livro: Livro) {
        livroDao.atualizarLivro(
            livro["titulo"] ?: "",
            livro["autor"] ?: "",
            livro["genero"] ?: "",
            livro["statusLeitura"] ?: "",
            livro["anotacoes"] ?: "",
            livro["id"]?.toInt() ?: 0
        )
    }

    // Função para excluir um livro
    suspend fun deleteLivro(id: Livro) = livroDao.excluirLivro(id) // Excluir por ID
}
