package com.example.rickandmortycompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.characterfilter.Filter
import com.example.rickandmortycompose.characterfilter.FilterSection
import com.example.rickandmortycompose.samples.FilterSectionProvider
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CharacterFilterSection(
    modifier: Modifier = Modifier,
    filterSection: FilterSection,
    selectedFilter: Filter? = null,
    chipBackgroundShape: CornerBasedShape = RoundedCornerShape(4.dp),
    onSectionItemSelected: (Filter, Boolean) -> Unit
) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = stringResource(id = filterSection.sectionTitle),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(mainAxisSpacing = 8.dp) {
            filterSection.filters.forEach { filter ->
                FilterChip(
                    filter = filter,
                    backgroundShape = chipBackgroundShape,
                    onSelectionChange = onSectionItemSelected,
                    isSelected = selectedFilter == filter
                )
            }
        }
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
