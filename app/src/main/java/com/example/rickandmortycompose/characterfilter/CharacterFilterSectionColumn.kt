package com.example.rickandmortycompose.characterfilter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.components.CharacterFilterSection
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme

@Composable
fun CharacterFilterSectionColumn(
    modifier: Modifier = Modifier,
    section: FilterSection,
    selectedFilter: Filter? = null,
    onSectionChipChange: (Filter, Boolean) -> Unit,
) {
    CharacterFilterSection(
        filterSection = section,
        onSectionItemSelected = onSectionChipChange,
        modifier = modifier,
        selectedFilter = selectedFilter
    )
}

@Preview
@Composable
fun CharacterFilterSectionColumnPreview() {
    RickAndMortyComposeTheme {
        Column {
            filterSections.forEach { filterSection ->
                CharacterFilterSectionColumn(section = filterSection) { _, _ ->

                }
            }
        }
    }
}
