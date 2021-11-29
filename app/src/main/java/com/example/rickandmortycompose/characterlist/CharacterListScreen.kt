package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.rickandmortycompose.characterfilter.CharacterFilter
import com.example.rickandmortycompose.characterfilter.rememberCharacterFilterState
import com.example.rickandmortycompose.network.response.Character
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = getViewModel(),
    onCharacterItemClicked: (Character) -> Unit
) {
    val characterFilterState = rememberCharacterFilterState()
    val lazyCharacterItems =
        characterListViewModel.characterListPagingData.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        CharacterFilter(
            filterState = characterFilterState,
            onFilterExpandClick = { isExpanded ->
                characterFilterState.expanded.value = isExpanded
            },
            onFilterChipSelect = { appliedFilter ->
                characterFilterState.addFilter(appliedFilter)
            },
            onFilterChipClose = { closedFilter ->
                characterFilterState.removeFilter(closedFilter)
            }
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(lazyCharacterItems) { character ->
                val validCharacter = character ?: return@items
                CharacterListItem(
                    character = validCharacter,
                    onCharacterItemClicked = onCharacterItemClicked
                )
            }
        }
    }
}

