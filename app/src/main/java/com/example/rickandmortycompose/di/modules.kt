package com.example.rickandmortycompose.di

import androidx.paging.PagingConfig
import com.example.rickandmortycompose.characterlist.CharacterListViewModel
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.network.CharacterService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class)
val networkModule = module {
    single {
        val contentType = MediaType.get("application/json")
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(Json.asConverterFactory(contentType = contentType))
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
    single { CharacterRepository(httpClient = get()) }
}