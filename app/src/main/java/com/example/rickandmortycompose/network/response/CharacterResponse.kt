package com.example.rickandmortycompose.network.response

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val info: ResponseInfo,
    val results: List<Character>
)