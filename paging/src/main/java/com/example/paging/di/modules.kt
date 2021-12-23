package com.example.paging.di

import com.example.paging.source.CharacterRemoteMediator
import org.koin.dsl.module

val pagingModule = module {
    single {
        CharacterRemoteMediator(
            characterService = get(),
            characterDatabase = get()
        )
    }
}
