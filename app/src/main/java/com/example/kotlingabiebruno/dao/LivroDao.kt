package com.example.kotlingabiebruno.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kotlingabiebruno.model.Livro

@Dao
interface LivroDao {
    @Insert
    suspend fun insert(livro: Livro)

    @Query("SELECT * FROM livro")
    suspend fun getAll(): List<Livro>

    @Update
    suspend fun update(livro: Livro)

    @Delete
    suspend fun delete(livro: Livro)
}
