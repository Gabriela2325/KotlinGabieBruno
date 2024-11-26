package com.example.kotlingabiebruno.repository

import android.content.Context
import com.example.kotlingabiebruno.database.DatabaseBuilder
import com.example.kotlingabiebruno.model.Cadernos

class CadernosRepository(context: Context) {
    private val cadernosDao = DatabaseBuilder.getInstance(context).cadernosDao()

    // Função para inserir um caderno
    suspend fun insertCaderno(caderno: Cadernos) {
        cadernosDao.insert(caderno)
    }

    // Função para atualizar um caderno
    suspend fun updateCaderno(caderno: Cadernos) {
        cadernosDao.update(caderno)
    }

    // Função para deletar um caderno
    suspend fun deleteCaderno(caderno: Cadernos) {
        cadernosDao.delete(caderno)
    }

    // Função para buscar todos os cadernos
    suspend fun getAllCadernos(): List<Cadernos> {
        return cadernosDao.getAll()
    }

    // Função para buscar um caderno por ID
    suspend fun getCadernoById(id: Int): Cadernos? {
        return cadernosDao.getById(id)
    }
}
