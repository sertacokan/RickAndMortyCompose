package com.example.rickandmortycompose.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.network.response.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterListViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    private val _characterList = MutableStateFlow(emptyList<Character>())
    val characterList: StateFlow<List<Character>> = _characterList

    init {
        fetchCharacterList()
    }

    private fun fetchCharacterList() {
        viewModelScope.launch {
            _characterList.value = characterRepository.getCharacterList()
        }
    }
}