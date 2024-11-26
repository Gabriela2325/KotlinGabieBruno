package com.example.kotlingabiebruno.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlingabiebruno.dao.*
import com.example.kotlingabiebruno.database.migration.model.*
import com.example.kotlingabiebruno.model.Cadernos
import com.example.kotlingabiebruno.model.Livro


// Liste a entidade 'Cadernos' no parâmetro 'entities'
@Database(entities = [Cadernos::class, Livro::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cadernosDao(): CadernosDao
    abstract fun livroDao(): LivroDao
}

