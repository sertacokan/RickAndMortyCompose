package com.example.rickandmortycompose.characterlist

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.database.character.CharacterEntity
import com.example.rickandmortycompose.characterfilter.CharacterFilter
import com.example.rickandmortycompose.characterfilter.rememberCharacterFilterState
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = getViewModel(),
    onCharacterItemClicked: (CharacterEntity) -> Unit
) {
    val characterFilterState = rememberCharacterFilterState()
    val lazyCharacterItems =
        characterListViewModel.characterList.collectAsLazyPagingItems()

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
            onFilterChipSelect = { appliedFilter, _ ->
                characterFilterState.addFilter(appliedFilter)
            },
            onFilterChipClose = { closedFilter ->
                characterFilterState.removeFilter(closedFilter)
            }
        )
        AnimatedVisibility(
            visible = lazyCharacterItems.itemCount != 0,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(lazyCharacterItems) { characterEntity ->
                    val validCharacter = characterEntity ?: return@items
                    CharacterListItem(
                        character = validCharacter,
                        onCharacterItemClicked = onCharacterItemClicked,
                        modifier = Modifier.animateEnterExit(
                            enter = fadeIn() + slideInVertically(),
                            exit = fadeOut() + slideOutVertically()
                        )
                    )
                }
            }
        }
    }
}
