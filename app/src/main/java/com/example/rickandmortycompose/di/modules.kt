package com.example.rickandmortycompose.di

import androidx.paging.PagingConfig
import com.example.network.CharacterRepository
import com.example.rickandmortycompose.characterdetail.CharacterDetailViewModel
import com.example.rickandmortycompose.characterlist.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CharacterListViewModel(characterRepository = get(), pagingConfig = get())
    }
    viewModel { (characterId: Int) ->
        CharacterDetailViewModel(characterRepository = get(), characterId = characterId)
    }
}

val testModule = module {
}

val repositoryModule = module {
    single {
        CharacterRepository(characterService = get())
    }
}

val pagingModule = module {
    single {
        PagingConfig(pageSize = 20, enablePlaceholders = false)
    }
}
