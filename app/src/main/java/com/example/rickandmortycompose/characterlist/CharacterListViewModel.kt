package com.example.rickandmortycompose.characterlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.paging.CharacterDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    private val _filters = MutableStateFlow(mutableListOf<String>())
    val filters: StateFlow<MutableList<String>> = _filters

    val characterListPagingData = Pager(config = PagingConfig(pageSize = 20, enablePlaceholders = false), initialKey = 1) {
        CharacterDataSource(characterRepository = characterRepository)
    }.flow.cachedIn(viewModelScope)

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