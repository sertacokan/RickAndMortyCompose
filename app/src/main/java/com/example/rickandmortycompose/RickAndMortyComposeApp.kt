package com.example.rickandmortycompose

import android.app.Application
import com.example.database.di.databaseModule
import com.example.di.networkModule
import com.example.paging.di.pagingModule
import com.example.rickandmortycompose.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RickAndMortyComposeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyComposeApp)
            modules(networkModule, viewModelModule, testModule, pagingModule, databaseModule)
        }
    }
}
