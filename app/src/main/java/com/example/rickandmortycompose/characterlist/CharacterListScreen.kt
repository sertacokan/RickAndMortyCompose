package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.rickandmortycompose.characterfilter.CharacterFilter
import com.example.rickandmortycompose.network.response.Character
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterListScreen(characterListViewModel: CharacterListViewModel = getViewModel(), onCharacterItemClicked: (Character) -> Unit) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val filterListFlow = characterListViewModel.filters
    val filterListFlowLifecycleAware = remember(key1 = filterListFlow, key2 = lifecycleOwner) {
        filterListFlow.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
    }

    val lazyCharacterItems = characterListViewModel.characterListPagingData.collectAsLazyPagingItems()
    val filterList by filterListFlowLifecycleAware.collectAsState(initial = emptyList())
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        CharacterFilter(
            selectedFilters = filterList,
            isExpanded = isExpanded,
            onFilterClicked = { isExpanded = !isExpanded },
            onChipSelected = { appliedFilter ->
                characterListViewModel.addFilter(filter = appliedFilter)
            },
            onChipClosed = { closedFilter ->
                characterListViewModel.removeFilter(closedFilter)
            }
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(lazyCharacterItems) { character ->
                val validCharacter = character ?: return@items
                CharacterListItem(character = validCharacter, onCharacterItemClicked = onCharacterItemClicked)
            }
        }
    }
}

