package com.example.rickandmortycompose.network

import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.network.response.CharacterResponse

class CharacterRepository(private val characterService: CharacterService) {

    suspend fun getCharacterList(): List<Character> {
        return httpClient.get {
            addPathNodes("")
        }
    }

    suspend fun getCharacterInfo(characterId: String): Character {
        return httpClient.get {
            addPathNodes("")
        }
    }
}
