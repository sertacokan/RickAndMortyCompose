package com.example.rickandmortycompose.network.response

import kotlinx.serialization.SerialName

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val url: String
) {
    val isAlive: Boolean get() = status == Status.Alive

    val isUnknown: Boolean get() = status == Status.Unknown
}

enum class Status {
    Alive,
    Dead,

    @SerialName("unknown")
    Unknown
}

enum class Gender {
    Female,
    Male,

    @SerialName("genderless")
    Genderless,

    @SerialName("unknown")
    Unknown
}

