package com.example.rickandmortycompose.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.network.response.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterListViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    private val _characterList = MutableStateFlow(emptyList<Character>())
    val characterList: StateFlow<List<Character>> = _characterList

    private val _queryText = MutableStateFlow("")
    val queryText: StateFlow<String> = _queryText

    init {
        fetchCharacterList()
    }

    fun searchCharacter(query: String) {
        _queryText.value = query
    }

    private fun fetchCharacterList() {
        viewModelScope.launch {
            _characterList.value = characterRepository.getCharacterList(pageNumber = 1)
        }
    }
}