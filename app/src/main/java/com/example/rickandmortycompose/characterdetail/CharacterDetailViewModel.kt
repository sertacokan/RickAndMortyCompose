package com.example.rickandmortycompose.characterdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.network.response.Character

class CharacterDetailViewModel(
    private val characterRepository: CharacterRepository,
    private val characterId: Int
) : ViewModel() {

    val characterInfo = liveData<Character> {
        characterRepository.fetchCharacterInfo(characterId = characterId)
    }

}