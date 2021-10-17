package com.example.rickandmortycompose.network

import androidx.compose.ui.graphics.vector.addPathNodes
import com.example.rickandmortycompose.network.response.Character
import io.ktor.client.*
import io.ktor.client.request.*

class CharacterRepository(private val httpClient: HttpClient) {

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