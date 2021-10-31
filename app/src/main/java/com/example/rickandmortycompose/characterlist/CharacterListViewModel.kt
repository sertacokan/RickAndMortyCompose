package com.example.rickandmortycompose.characterlist

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.paging.CharacterDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest

class CharacterListViewModel(private val characterRepository: CharacterRepository, private val pagingConfig: PagingConfig) : ViewModel() {

    private val _queryText = MutableStateFlow("")
    val queryText: StateFlow<String> = _queryText

    val characterListPagingData = _queryText
        .debounce(QUERY_DEBOUNCE)
        .flatMapLatest { query ->
            Pager(config = pagingConfig) {
                CharacterDataSource(characterRepository = characterRepository, query = query)
            }.flow
        }

    fun searchCharacter(query: String) {
        _queryText.value = query
    }

    companion object {
        private const val QUERY_DEBOUNCE = 300L
    }
}