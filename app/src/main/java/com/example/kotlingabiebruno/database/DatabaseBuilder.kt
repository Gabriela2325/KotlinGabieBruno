//package com.example.kotlingabiebruno.database
//
//import android.content.Context
//import androidx.room.Room
//import androidx.room.migration.Migration
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.example.kotlingabiebruno.database.migration.MIGRATION_1_2
//
//object DatabaseBuilder {
//
//    @Volatile
//    private var INSTANCE: AppDatabase? = null
//
//    fun getInstance(context: Context): AppDatabase {
//        return INSTANCE ?: synchronized(this) {
//            val instance = Room.databaseBuilder(
//                context.applicationContext,
//                AppDatabase::class.java,
//                "app_database"
//            )
//                .addMigrations(MIGRATION_1_2) // Certifique-se de que a migração seja passada aqui
//                .build()
//            INSTANCE = instance
//            instance
//        }
//    }
//}
package com.example.kotlingabiebruno.database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            )
                .fallbackToDestructiveMigration() // Garante que o banco será recriado se houver mudanças
                .build()
            INSTANCE = instance
            instance
        }
    }
}
