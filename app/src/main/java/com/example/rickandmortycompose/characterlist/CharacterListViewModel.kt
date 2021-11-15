package com.example.rickandmortycompose.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.paging.CharacterDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    private val _queryText = MutableStateFlow("")
    val queryText: StateFlow<String> = _queryText

    val characterListPagingData = _queryText
        .debounce(QUERY_DEBOUNCE)
        .flatMapLatest { query ->
            Pager(config = PagingConfig(pageSize = 20, enablePlaceholders = false), initialKey = 1) {
                CharacterDataSource(characterRepository = characterRepository, query = query)
            }.flow.cachedIn(viewModelScope)
        }

    fun searchCharacter(query: String) {
        _queryText.value = query
    }

    companion object {
        private const val QUERY_DEBOUNCE = 300L
    }
}