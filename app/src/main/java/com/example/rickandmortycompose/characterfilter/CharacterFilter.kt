package com.example.rickandmortycompose.characterfilter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.components.CloseableFilterChip
import com.example.rickandmortycompose.components.FilterSection
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CharacterFilter(
    modifier: Modifier = Modifier,
    filterSection: List<FilterSection> = emptyList(),
    filterState: CharacterFilterState = rememberCharacterFilterState(),
    onFilterExpandClick: (isExpanded: Boolean) -> Unit = {},
    onFilterChipSelect: (String) -> Unit = {},
    onFilterChipClose: (String) -> Unit = {}
) {
    Card(modifier = modifier.padding(vertical = 8.dp)) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                FlowRow(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    mainAxisSpacing = 4.dp,
                    crossAxisSpacing = 4.dp
                ) {
                    filterState.selectedFilters.forEach { filterText ->
                        CloseableFilterChip(text = filterText, onCloseClicked = onFilterChipClose)
                    }
                }
                IconButton(onClick = {
                    onFilterExpandClick(!filterState.expanded.value)
                }) {
                    Icon(imageVector = Icons.Outlined.FilterList, contentDescription = null)
                }
            }
            AnimatedVisibility(visible = filterState.expanded.value) {
                CharacterFilterSectionColumn(
                    modifier = Modifier.fillMaxWidth(),
                    onSectionChipChange = onFilterChipSelect,
                    sections = filterSection
                )
            }
        }
    }
}

@Preview
@Composable
fun CharacterFilterPreview() {
    val filterState = rememberCharacterFilterState()
    CharacterFilter(
        filterState = filterState,
        onFilterChipSelect = { selectedChip -> filterState.addFilter(selectedChip) },
        onFilterExpandClick = { isExpanded -> filterState.updateExpand(isExpanded) },
        onFilterChipClose = { closedChipText ->
            filterState.removeFilter(closedChipText)
        }
    )
}
