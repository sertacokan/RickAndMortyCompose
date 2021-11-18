package com.example.rickandmortycompose.di

import com.example.rickandmortycompose.characterlist.CharacterListViewModel
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.network.CharacterService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

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
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
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