package com.example.network.response

import com.squareup.moshi.Json

data class Character(
    val id: Int,
    val name: String,
    @Json(name = "image")
    val imageUrl: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val url: String
)

enum class Status {
    Alive,
    Dead,

    @Json(name = "unknown")
    Unknown
}

enum class Gender {
    Female,
    Male,

    Genderless,

    @Json(name = "unknown")
    Unknown
}
