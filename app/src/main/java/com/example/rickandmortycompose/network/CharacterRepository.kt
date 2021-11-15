package com.example.rickandmortycompose.network

import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.network.response.CharacterResponse

class CharacterRepository(private val characterService: CharacterService) {

    suspend fun fetchCharacterList(pageNumber: Int): CharacterResponse {
        return characterService.fetchCharacterList(pageNumber = pageNumber)
    }

    suspend fun fetchCharacterInfo(characterId: String): Character {
        return characterService.fetchCharacterInfoById(characterId = characterId)
    }

    suspend fun fetchCharacterListByName(name: String, pageNumber: Int): CharacterResponse {
        return characterService.fetchCharacterListByName(name = name, pageNumber = pageNumber)
    }
}
