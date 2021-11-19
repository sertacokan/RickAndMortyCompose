package com.example.rickandmortycompose.characterfilter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.components.CloseableFilterChip
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CharacterFilter(
    modifier: Modifier = Modifier,
    selectedFilters: List<String> = emptyList(),
    isExpanded: Boolean = false,
    onFilterClicked: () -> Unit = {},
    onChipSelected: (String) -> Unit = {},
    onChipClosed: (String) -> Unit = {}
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
                    selectedFilters.forEach { filterText -> CloseableFilterChip(text = filterText, onCloseClicked = onChipClosed) }
                }
                IconButton(onClick = onFilterClicked) {
                    Icon(imageVector = Icons.Outlined.FilterList, contentDescription = null)
                }
            }
            AnimatedVisibility(visible = isExpanded) {
                CharacterFilterSectionColumn(modifier = Modifier.fillMaxWidth(), onSectionChipChange = onChipSelected)
            }
        }
    }
}

@Preview
@Composable
fun CharacterFilterPreview() {
    var isExpanded by remember { mutableStateOf(false) }
    val selectedChipList = remember { mutableStateListOf<String>() }

    CharacterFilter(
        selectedFilters = selectedChipList,
        isExpanded = isExpanded,
        onChipSelected = { selectedChip -> selectedChipList.add(selectedChip) },
        onFilterClicked = { isExpanded = !isExpanded },
        onChipClosed = { closedChipText ->
            selectedChipList.remove(closedChipText)
        }
    )
}