package com.example.rickandmortycompose.di

import com.example.rickandmortycompose.characterlist.CharacterListViewModel
import com.example.rickandmortycompose.network.CharacterRepository
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(Android) {
            engine {
                connectTimeout = 60_000
            }
            defaultRequest {
                host = "https://rickandmortyapi.com/api/character"
            }
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.BODY
            }
        }
    }
}

val viewModelModule = module {
    viewModel {
        CharacterListViewModel(characterRepository = get())
    }
}

val testModule = module {

}

val repositoryModule = module {
    single { CharacterRepository(httpClient = get()) }
}