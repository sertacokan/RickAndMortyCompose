package com.example.rickandmortycompose.network.response

data class CharacterResponse(
    val info: ResponseInfo,
    val results: List<Character>
)