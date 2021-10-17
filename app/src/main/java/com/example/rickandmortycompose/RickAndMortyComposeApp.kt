package com.example.rickandmortycompose

import android.app.Application
import com.example.rickandmortycompose.di.networkModule
import com.example.rickandmortycompose.di.repositoryModule
import com.example.rickandmortycompose.di.testModule
import com.example.rickandmortycompose.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RickAndMortyComposeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyComposeApp)
            androidLogger(Level.DEBUG)
            modules(networkModule, viewModelModule, testModule, repositoryModule)
        }
    }
}