package com.example.rickandmortycompose.network

import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.network.response.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun fetchCharacterList(@Query("page") pageNumber: Int): CharacterResponse

    @GET("character/{characterId}")
    suspend fun fetchCharacterInfoById(@Path("characterId") characterId: String): Character

    @GET("character")
    suspend fun fetchCharacterListByName(@Query("name") name: String, @Query("page") pageNumber: Int): CharacterResponse
}