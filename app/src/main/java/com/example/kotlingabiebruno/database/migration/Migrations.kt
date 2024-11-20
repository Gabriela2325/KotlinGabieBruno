package com.example.kotlingabiebruno.database.migration


import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// Migração da versão 1 para 2
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Adicionando a nova tabela "Cadernos"
        database.execSQL("""
            CREATE TABLE IF NOT EXISTS `Cadernos` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `nome` TEXT NOT NULL
            )
        """)
    }
}