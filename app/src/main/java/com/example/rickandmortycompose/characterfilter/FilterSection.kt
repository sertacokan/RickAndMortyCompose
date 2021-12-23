package com.example.rickandmortycompose.characterfilter

import androidx.annotation.StringRes

data class FilterSection(
    @StringRes val sectionTitle: Int,
    val filters: List<Filter>
)

val genderFilters = listOf(
    GenderFilter("Female"),
    GenderFilter("Male"),
    GenderFilter("Genderless"),
    GenderFilter("Unknown")
)

val statusFilters = listOf(
    StatusFilter("Alive"),
    StatusFilter("Dead"),
    StatusFilter("Unknown")
)

sealed class Filter {
    abstract val name: String
    abstract val isEnabled: Boolean
}

data class GenderFilter(
    override val name: String,
    override val isEnabled: Boolean = false
) : Filter()

data class StatusFilter(
    override val name: String,
    override val isEnabled: Boolean = false
) : Filter()
