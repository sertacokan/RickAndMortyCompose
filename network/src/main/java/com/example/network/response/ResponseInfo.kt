package com.example.network.response

data class ResponseInfo(
    val count: Int,
    val pages: Int,
    val next: String? = null,
    val prev: String? = null
)
