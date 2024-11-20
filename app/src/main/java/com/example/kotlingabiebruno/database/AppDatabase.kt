package com.example.kotlingabiebruno.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlingabiebruno.dao.CadernosDao
import com.example.kotlingabiebruno.dao.LivroDao
import com.example.kotlingabiebruno.model.Cadernos
import com.example.kotlingabiebruno.model.Livro

@Database(entities = [Livro::class,Cadernos::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun livroDao(): LivroDao
    abstract fun CadernosDao(): CadernosDao
}
