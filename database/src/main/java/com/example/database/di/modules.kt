package com.example.database.di

import androidx.room.Room
import com.example.database.character.CharacterDatabase
import com.example.database.repository.CharacterRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), CharacterDatabase::class.java, "character_db")
            .build()
    }
    single {
        get<CharacterDatabase>().characterDao()
    }
    single {
        get<CharacterDatabase>().remoteKeyDao()
    }
    single {
        CharacterRepository(characterDao = get())
    }
}
