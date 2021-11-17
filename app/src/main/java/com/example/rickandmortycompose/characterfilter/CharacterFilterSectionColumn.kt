package com.example.rickandmortycompose.characterfilter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.components.CharacterFilterSection
import com.example.rickandmortycompose.components.FilterSection

@Composable
fun CharacterFilterSectionColumn(
    modifier: Modifier = Modifier,
    sections: List<FilterSection> = listOf(
        FilterSection(R.string.character_gender_title, listOf("Female", "Male", "Genderless", "Unknown"), "Unknown"),
        FilterSection(R.string.character_status_title, listOf("Alive", "Dead", "Unknown"), "Alive")
    ),
    onSectionChipChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        sections.forEach { filterSection ->
            CharacterFilterSection(
                filterSection = filterSection,
                onSectionItemSelected = onSectionChipChange,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}

@Preview
@Composable
fun CharacterFilterSectionColumnPreview() {
    CharacterFilterSectionColumn(
        sections = listOf(
            FilterSection(R.string.character_gender_title, listOf("Female", "Male", "Genderless", "Unknown"), "Unknown"),
            FilterSection(R.string.character_status_title, listOf("Alive", "Dead", "Unknown"), "Alive")
        ),
    ) {

    }
}