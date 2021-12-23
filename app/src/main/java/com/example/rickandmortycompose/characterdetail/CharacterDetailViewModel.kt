package com.example.rickandmortycompose.characterdetail

import androidx.lifecycle.ViewModel
import com.example.database.repository.CharacterRepository

class CharacterDetailViewModel(
    characterId: Int,
    characterRepository: CharacterRepository
) : ViewModel() {

    val characterInfo = characterRepository.getCharacterById(characterId = characterId)
}
