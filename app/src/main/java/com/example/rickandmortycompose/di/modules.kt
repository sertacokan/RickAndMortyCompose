package com.example.rickandmortycompose.di

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(Android) {
            engine {
                connectTimeout = 60_000
            }
            defaultRequest {
                host = "https://rickandmortyapi.com/api"
            }
        }
    }
}

val viewModelModule = module {

}

val testModule = module {

}

val repositoryModule = module {

}