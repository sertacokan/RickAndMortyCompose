package com.example.rickandmortycompose.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.paging.CharacterDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListViewModel(
    private val characterRepository: CharacterRepository,
    pagingConfig: PagingConfig
) : ViewModel() {

    val characterListPagingData = Pager(config = pagingConfig, initialKey = 1) {
        CharacterDataSource(characterRepository = characterRepository)
    }.flow.cachedIn(viewModelScope)
}
