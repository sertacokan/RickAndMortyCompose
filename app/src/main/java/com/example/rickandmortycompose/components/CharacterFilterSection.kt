package com.example.rickandmortycompose.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.samples.FilterSectionProvider
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CharacterFilterSection(
    modifier: Modifier = Modifier,
    filterSection: FilterSection,
    onSectionItemSelected: (String, Boolean) -> Unit
) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = stringResource(id = filterSection.sectionTitleRes),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(mainAxisSpacing = 8.dp) {
            filterSection.sectionChips.forEach { chipText ->
                InfoChip(
                    text = chipText,
                    backgroundShape = RoundedCornerShape(4.dp),
                    onSelectionChange = onSectionItemSelected
                )
            }
        }
    }
}

enum class FilterSection(@StringRes val sectionTitleRes: Int, val sectionChips: List<String>) {
    GENDER(R.string.character_gender_title, listOf("Female", "Male", "Genderless", "Unknown")),
    STATUS(R.string.character_status_title, listOf("Alive", "Dead", "Unknown"));

    companion object {
        val sections = values()
    }
}

@Preview
@Composable
fun CharacterFilterSectionPreview(@PreviewParameter(FilterSectionProvider::class) filterSection: FilterSection) {
    CharacterFilterSection(
        filterSection = filterSection,
        modifier = Modifier.fillMaxWidth()
    ) { _, _ ->
    }
}
