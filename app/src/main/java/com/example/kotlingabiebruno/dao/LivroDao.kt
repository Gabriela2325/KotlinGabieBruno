package com.example.kotlingabiebruno.dao

import androidx.room.*
import com.example.kotlingabiebruno.model.Livro

@Dao
interface LivroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(livro: Livro)

    @Update
    suspend fun atualizarLivro(livro: Livro)

    @Delete
    suspend fun excluirLivro(livro: Livro)

    @Query("SELECT * FROM livros")
    suspend fun getAll(): List<Livro>
}

