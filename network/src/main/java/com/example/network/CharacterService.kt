package com.example.network

import com.example.network.response.Character
import com.example.network.response.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character/")
    suspend fun fetchCharacterList(
        @Query("page") pageNumber: Int
    ): CharacterResponse

    @GET("character/{characterId}")
    suspend fun fetchCharacterInfoById(
        @Path("characterId") characterId: Int
    ): Character
}
