package com.example.aura.repository

import com.example.aura.data.db.BootEvent
import com.example.aura.sourse.AppDatabase


interface IBootEventRepository {

    suspend fun insertBootEvent(bootEvent: BootEvent)

    suspend fun getAllBootEvents(): List<BootEvent>


}

class BootEventRepository(
    private val appDatabase: AppDatabase,
) : IBootEventRepository {
    override suspend fun insertBootEvent(bootEvent: BootEvent) {
        appDatabase.bootEventDao().insertBootEvent(bootEvent)
    }

    override suspend fun getAllBootEvents(): List<BootEvent> {
        return appDatabase.bootEventDao().getAllBootEvents()
    }
}