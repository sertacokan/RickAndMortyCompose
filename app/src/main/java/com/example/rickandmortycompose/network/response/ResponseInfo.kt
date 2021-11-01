package com.example.rickandmortycompose.network.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseInfo(
    val count: Int,
    val pages:Int
)
