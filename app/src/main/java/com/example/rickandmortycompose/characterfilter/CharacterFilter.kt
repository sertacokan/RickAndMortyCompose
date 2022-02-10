package com.example.rickandmortycompose.characterfilter

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
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
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CharacterFilter(
    modifier: Modifier = Modifier,
    filterState: CharacterFilterState = rememberCharacterFilterState(),
    onFilterExpandClick: (isExpanded: Boolean) -> Unit = {},
    onFilterChipSelect: (Filter, Boolean) -> Unit = { _, _ -> },
    onFilterChipClose: (Filter) -> Unit = {}
) {
    Card(modifier = modifier) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                FlowRow(
                    modifier = Modifier
                        .padding(4.dp)
                        .weight(1f),
                    mainAxisSpacing = 4.dp,
                    crossAxisSpacing = 4.dp
                ) {
                    filterState.selectedFilters.forEach { filter ->
                        CloseableFilterChip(filter = filter, onCloseClicked = onFilterChipClose)
                    }
                }
                IconButton(onClick = { onFilterExpandClick(!filterState.isExpanded) }) {
                    Icon(imageVector = Icons.Outlined.FilterList, contentDescription = null)
                }
            }
            AnimatedVisibility(visible = filterState.isExpanded) {
                Column(
                    modifier = modifier,
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    filterSections.forEachIndexed { index, filterSection ->
                        CharacterFilterSectionColumn(
                            modifier = Modifier.fillMaxWidth(),
                            onSectionChipChange = onFilterChipSelect,
                            section = filterSection,
                            selectedFilter = filterState.selectedFilters.getOrNull(index)
                        )
                    }
                }
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
fun CharacterFilterPreview() {
    RickAndMortyComposeTheme {
        val filterState = rememberCharacterFilterState()
        CharacterFilter(
            filterState = filterState,
            onFilterExpandClick = { isExpanded ->
                if (isExpanded) {
                    filterState.expand()
                } else {
                    filterState.collapse()
                }
            },
            onFilterChipSelect = { selectedChip, _ ->
                filterState.addFilter(selectedChip)
            },
            onFilterChipClose = { closedChipText ->
                filterState.removeFilter(closedChipText)
            }
        )
    }
}
