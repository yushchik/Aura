package com.example.aura.sourse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aura.data.db.BootEvent

@Database(entities = [BootEvent::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bootEventDao(): BootEventDao
}