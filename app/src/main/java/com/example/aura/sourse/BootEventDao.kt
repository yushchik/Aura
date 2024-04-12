package com.example.aura.sourse

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aura.data.db.BootEvent

@Dao
interface BootEventDao {
    @Insert
    suspend fun insertBootEvent(bootEvent: BootEvent)

    @Query("SELECT * FROM boot_event")
    suspend fun getAllBootEvents(): List<BootEvent>
}