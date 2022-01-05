package com.example.rickandmortycompose.characterlist

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.database.character.CharacterEntity
import com.example.rickandmortycompose.characterfilter.CharacterFilter
import com.example.rickandmortycompose.characterfilter.rememberCharacterFilterState
import com.example.rickandmortycompose.components.LottieGlootLoading
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = getViewModel(),
    onCharacterItemClicked: (CharacterEntity) -> Unit
) {
    val characterFilterState = rememberCharacterFilterState()
    val lazyCharacterItems = characterListViewModel.characterList.collectAsLazyPagingItems()
    val isListEmpty = lazyCharacterItems.itemSnapshotList.isEmpty()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        CharacterFilter(
            filterState = characterFilterState,
            onFilterExpandClick = { isExpanded ->
                if (isExpanded) {
                    characterFilterState.expand()
                } else {
                    characterFilterState.collapse()
                }
            },
            onFilterChipSelect = { selectedFilter, isSelected ->
                if (isSelected) {
                    characterFilterState.addFilter(selectedFilter)
                } else {
                    characterFilterState.removeFilter(selectedFilter)
                }
            },
            onFilterChipClose = { closedFilter ->
                characterFilterState.removeFilter(closedFilter)
            }
        )

        if (isListEmpty) {
            LottieGlootLoading(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(lazyCharacterItems) { characterEntity ->
                    val validCharacter = characterEntity ?: return@items
                    CharacterListItem(
                        character = validCharacter,
                        onCharacterItemClicked = onCharacterItemClicked
                    )
                }
                val loadState = lazyCharacterItems.loadState
                if (loadState.source.append == LoadState.Loading || loadState.mediator?.refresh == LoadState.Loading) {
                    item {
                        LottieGlootLoading(
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}
