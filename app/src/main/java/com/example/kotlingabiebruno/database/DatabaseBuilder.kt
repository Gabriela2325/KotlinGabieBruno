package com.example.kotlingabiebruno.database

import android.content.Context
import androidx.room.Room
import com.example.kotlingabiebruno.database.migration.MIGRATION_1_2

object DatabaseBuilder {
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addMigrations(MIGRATION_1_2) // Registre as migrações aqui
                    .build()
            }
        }
        return INSTANCE!!
    }
}