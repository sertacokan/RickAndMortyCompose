package com.example.rickandmortycompose.di

import com.example.rickandmortycompose.characterdetail.CharacterDetailViewModel
import com.example.rickandmortycompose.characterlist.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CharacterListViewModel(characterRemoteMediator = get(), characterRepository = get())
    }
    viewModel { (characterId: Int) ->
        CharacterDetailViewModel(characterId = characterId, characterRepository = get())
    }
}

val testModule = module {
}
