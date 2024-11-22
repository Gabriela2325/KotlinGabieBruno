package com.example.kotlingabiebruno.database.migration.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livros")
data class Livro(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val autor: String,
    val genero: String,
    val statusLeitura: String, // "Lido", "Em Leitura", "Planejado"
    val anotacoes: String
)
