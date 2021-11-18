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
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    private val _queryText = MutableStateFlow("")
    private val _filters = MutableStateFlow(mutableListOf<String>())
     val filters: StateFlow<MutableList<String>> = _filters

    val characterListPagingData = _queryText
        .flatMapLatest { query ->
            Pager(config = PagingConfig(pageSize = 20, enablePlaceholders = false), initialKey = 1) {
                CharacterDataSource(characterRepository = characterRepository, query = query)
            }.flow.cachedIn(viewModelScope)
        }

    fun addFilter(filter: String) {
        _filters.update { filters ->
            filters.add(filter)
            filters
        }
    }

    fun removeFilter(filter: String) {
        _filters.update { filters ->
            filters.remove(filter)
            filters
        }
    }
}