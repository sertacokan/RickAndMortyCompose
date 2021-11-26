package com.example.rickandmortycompose.characterfilter

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.rickandmortycompose.components.FilterSection
import java.io.Serializable


class CharacterFilterState(isExpanded: Boolean = false) : Serializable {
    val selectedFilters = mutableStateListOf<String>()
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
fun rememberCharacterFilterState(isExpanded: Boolean = false): CharacterFilterState {
    return rememberSaveable {
        CharacterFilterState(isExpanded = isExpanded)
    }
}