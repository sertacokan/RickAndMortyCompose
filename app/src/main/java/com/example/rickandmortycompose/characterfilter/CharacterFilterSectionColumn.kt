package com.example.rickandmortycompose.characterfilter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.components.CharacterFilterSection
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme

// TODO : Change selected chip color
// TODO : Single selection issue
@Composable
fun CharacterFilterSectionColumn(
    modifier: Modifier = Modifier,
    sections: List<FilterSection>,
    onSectionChipChange: (Filter, Boolean) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        sections.forEach { filterSection ->
            CharacterFilterSection(
                filterSection = filterSection,
                onSectionItemSelected = onSectionChipChange,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun CharacterFilterSectionColumnPreview() {
    RickAndMortyComposeTheme {
        val filterSections = listOf(
            FilterSection(R.string.character_gender_title, genderFilters),
            FilterSection(R.string.character_status_title, statusFilters)
        )
        CharacterFilterSectionColumn(sections = filterSections) { _, _ ->
        }
    }
}
