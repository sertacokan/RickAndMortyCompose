package com.example.rickandmortycompose.characterfilter

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import java.io.Serializable

@Stable
class CharacterFilterState(
    isExpanded: Boolean = false,
    sectionItems: Array<String> = emptyArray()
) : Serializable {
    private var _selectedFilters = mutableStateListOf(*sectionItems)
    private var _isExpanded by mutableStateOf(isExpanded)

    var isExpanded: Boolean
        get() = this._isExpanded
        set(value) {
            this._isExpanded = value
        }

    val selectedFilter = _selectedFilters

    fun removeFilter(filter: String) {
        _selectedFilters.remove(filter)
    }

    fun addFilter(filter: String) {
        _selectedFilters.add(filter)
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