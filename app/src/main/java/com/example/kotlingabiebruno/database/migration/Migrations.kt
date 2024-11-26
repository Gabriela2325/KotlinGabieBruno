package com.example.kotlingabiebruno.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// Defina a migração de 1 para 2
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Exemplo de alteração: Adicionando uma nova tabela ou coluna
        // Aqui, vamos adicionar uma nova tabela de exemplo para a versão 2
        database.execSQL("CREATE TABLE IF NOT EXISTS `nova_tabela` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL)")
    }
}
