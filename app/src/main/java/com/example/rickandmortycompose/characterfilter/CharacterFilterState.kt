package com.example.rickandmortycompose.characterfilter

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import java.io.Serializable

@Stable
class CharacterFilterState(
    isExpanded: Boolean = false,
    sectionItems: List<Filter> = emptyList()
) : Serializable {

    var selectedFilters by mutableStateOf(sectionItems)
        private set

    var isExpanded by mutableStateOf(isExpanded)
        private set

    fun expand() {
        isExpanded = true
    }

    fun collapse() {
        isExpanded = false
    }

    fun removeFilter(filter: Filter) {
        selectedFilters = selectedFilters - filter
    }

    fun addFilter(filter: Filter) {
        selectedFilters = selectedFilters + filter
    }
}

@Composable
fun rememberCharacterFilterState(
    isExpanded: Boolean = false,
    sectionItems: List<Filter> = emptyList()
): CharacterFilterState {
    return rememberSaveable {
        CharacterFilterState(isExpanded = isExpanded, sectionItems = sectionItems)
    }
}
