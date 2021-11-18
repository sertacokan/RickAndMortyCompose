package com.example.rickandmortycompose.characterfilter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.components.CloseableInfoChip
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CharacterFilter(
    selectedFilters: List<String> = emptyList(),
    isExpanded: Boolean = false,
    onFilterClicked: () -> Unit = {},
    onChipSelected: (String) -> Unit = {},
    onChipClosed: (String) -> Unit = {}
) {
    Column {
        Row {
            FlowRow(
                modifier = Modifier
                    .weight(1f)
                    .padding(2.dp),
                mainAxisSpacing = 2.dp,
                crossAxisSpacing = 2.dp
            ) {
                selectedFilters.forEach { filterText -> CloseableInfoChip(text = filterText, onCloseClicked = onChipClosed) }
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

@Preview
@Composable
fun CharacterFilterPreview() {
    var isExpanded by remember { mutableStateOf(false) }
    val selectedChipList = remember {
        mutableStateListOf<String>()
    }

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