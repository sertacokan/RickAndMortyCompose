package com.example.rickandmortycompose.characterdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.network.response.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    private val _characterDetailFlow = MutableStateFlow<Character?>(null)
    val characterDetailFlow: StateFlow<Character?> = _characterDetailFlow

    private fun fetchCharacterDetail(characterId: String) {
        viewModelScope.launch {
            _characterDetailFlow.value =
                characterRepository.fetchCharacterInfo(characterId = characterId)
        }
    }
}