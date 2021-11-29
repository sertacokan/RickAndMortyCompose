package com.example.rickandmortycompose.characterfilter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import java.io.Serializable


class CharacterFilterState(
    isExpanded: Boolean = false,
    sectionItems: Array<String> = emptyArray()
) : Serializable {
    val selectedFilters = mutableStateListOf(*sectionItems)
    val expanded = mutableStateOf(isExpanded)

    fun removeFilter(filter: String) {
        selectedFilters.remove(filter)
    }

    fun addFilter(filter: String) {
        selectedFilters.add(filter)
    }

    fun updateExpand(isExpanded: Boolean) {
        this.expanded.value = isExpanded
    }
}

@Composable
fun rememberCharacterFilterState(
    isExpanded: Boolean = false,
    sectionItems: Array<String> = emptyArray()
): CharacterFilterState {
    return rememberSaveable {
        CharacterFilterState(isExpanded = isExpanded, sectionItems = sectionItems)
    }
}