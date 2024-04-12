package com.example.aura.di

import androidx.room.Room
import com.example.aura.repository.BootEventRepository
import com.example.aura.repository.IBootEventRepository
import com.example.aura.sourse.AppDatabase
import com.example.aura.util.Constants.BOOT_DATABASE
import com.example.aura.viewmodel.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            BOOT_DATABASE
        ).build()
    }

    single<IBootEventRepository> { BootEventRepository(get()) }
    viewModelOf(::MainActivityViewModel)
}