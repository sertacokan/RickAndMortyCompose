package com.example.rickandmortycompose.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
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

@Serializable
enum class Status {
    Alive,
    Dead,

    @SerialName("unknown")
    Unknown
}

@Serializable
enum class Gender {
    Female,
    Male,

    @SerialName("genderless")
    Genderless,

    @SerialName("unknown")
    Unknown
}

