package com.example.rickandmortycompose.di

import com.example.rickandmortycompose.characterlist.CharacterListViewModel
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.network.CharacterService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalSerializationApi::class)
val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .build()
    }
    single {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(Json.asConverterFactory(contentType = contentType))
            .client(get())
            .build()
    }
    single {
        get<Retrofit>().create(CharacterService::class.java)
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
    single {
        CharacterRepository(characterService = get())
    }
}