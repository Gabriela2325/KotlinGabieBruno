package com.example.kotlingabiebruno.dao

import androidx.room.*
import com.example.kotlingabiebruno.database.migration.model.Cadernos

@Dao
interface CadernosDao {

    // Inserir um caderno
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(caderno: Cadernos)

    // Atualizar um caderno
    @Update
    suspend fun update(caderno: Cadernos)

    // Deletar um caderno
    @Delete
    suspend fun delete(caderno: Cadernos)

    // Buscar todos os cadernos
    @Query("SELECT * FROM Cadernos")
    suspend fun getAll(): List<Cadernos>

    // Buscar caderno por ID
    @Query("SELECT * FROM Cadernos WHERE id = :id")
    suspend fun getById(id: Int): Cadernos?
}
