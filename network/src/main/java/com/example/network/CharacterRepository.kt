package com.example.network

import com.example.network.response.Character
import com.example.network.response.CharacterResponse

class CharacterRepository(private val characterService: CharacterService) {

    suspend fun fetchCharacterList(
        pageNumber: Int,
        gender: String?,
        status: String?
    ): CharacterResponse {
        return characterService.fetchCharacterList(
            pageNumber = pageNumber,
            gender = gender,
            status = status
        )
    }

    suspend fun fetchCharacterInfo(characterId: Int): Character {
        return characterService.fetchCharacterInfoById(characterId = characterId)
    }
}
