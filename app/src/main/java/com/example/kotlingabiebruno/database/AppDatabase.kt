package com.example.kotlingabiebruno.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlingabiebruno.dao.CadernosDao
import com.example.kotlingabiebruno.database.migration.model.Livro // Esta parte pode ser removida se você substituir o Livro

@Database(entities = [], version = 1) // Entidade foi removida
abstract class AppDatabase : RoomDatabase() {
    abstract fun livroDao(): LivroDao // Referência ao DAO para Livro
    abstract fun CadernosDao(): CadernosDao
}
