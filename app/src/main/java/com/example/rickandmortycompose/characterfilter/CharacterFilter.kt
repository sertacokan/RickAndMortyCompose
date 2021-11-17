package com.example.rickandmortycompose.characterfilter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Filter
import androidx.compose.material.icons.twotone.Filter1
import androidx.compose.material.icons.twotone.FilterList
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmortycompose.components.InfoChip
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CharacterFilter(selectedFilters: List<String> = emptyList(), isExpanded: Boolean = false, onFilterClicked: () -> Unit) {
    Column {
        Row {
            FlowRow(modifier = Modifier.weight(1f)) {
                selectedFilters.forEach { filterText -> InfoChip(text = filterText) }
            }
            IconButton(onClick = onFilterClicked) {
                Icon(imageVector = Icons.TwoTone.FilterList, contentDescription = null)
            }
        }
        AnimatedVisibility(visible = isExpanded) {
            CharacterFilterSectionColumn(modifier = Modifier.fillMaxWidth()) {}
        }
    }
}


@Preview
@Composable
fun CharacterFilterPreview() {
    var isExpanded by remember { mutableStateOf(true) }

    CharacterFilter(selectedFilters = emptyList(), isExpanded = isExpanded) {
        isExpanded = !isExpanded
    }
}