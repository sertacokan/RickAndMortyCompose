package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmortycompose.components.SearchBar
import com.example.rickandmortycompose.network.response.Character
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterListScreen(characterListViewModel: CharacterListViewModel = getViewModel(), onCharacterItemClicked: (Character) -> Unit) {
    val lazyCharacterItems = characterListViewModel.characterListPagingData.collectAsLazyPagingItems()
    val queryTextState by characterListViewModel.queryText.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        SearchBar(
            query = queryTextState,
            onQueryChanged = { query ->
                characterListViewModel.searchCharacter(query = query)
            }
        )
        LazyColumn {
            items(lazyCharacterItems.itemCount) { index ->
                lazyCharacterItems[index]?.let { character ->
                    CharacterListItem(character = character, onCharacterItemClicked = onCharacterItemClicked)
                }
            }
        }
    }
}

@Preview
@Composable
fun CharacterListScreenPreview() {
    CharacterListScreen {

    }
}
