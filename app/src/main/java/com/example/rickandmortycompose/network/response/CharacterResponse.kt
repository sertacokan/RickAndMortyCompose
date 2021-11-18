package com.example.rickandmortycompose.network.response


data class CharacterResponse(
    val info: ResponseInfo,
    val next: String? = null,
    val prev: String? = null,
    val results: List<Character>
)