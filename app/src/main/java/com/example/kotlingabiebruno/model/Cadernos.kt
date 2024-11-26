package com.example.kotlingabiebruno.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cadernos")
data class Cadernos(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val descricao: String,
    val dataCriacao: Long
)

