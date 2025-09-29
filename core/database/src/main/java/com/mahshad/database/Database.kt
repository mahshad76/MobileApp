package com.mahshad.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ObjectEntity::class], version = 1, exportSchema = true)
abstract class Database : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        const val DATABASE_NAME = "object_database"
    }
}