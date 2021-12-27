package com.example.rickandmortycompose.characterfilter

import androidx.annotation.StringRes
import com.example.rickandmortycompose.R

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

val filterSections = listOf(
    FilterSection(
        sectionTitle = R.string.character_status_title,
        filters = statusFilters
    ),
    FilterSection(
        sectionTitle = R.string.character_gender_title,
        filters = genderFilters
    )
)

sealed class Filter {
    abstract val name: String
}

data class GenderFilter(
    override val name: String
) : Filter()

data class StatusFilter(
    override val name: String
) : Filter()
