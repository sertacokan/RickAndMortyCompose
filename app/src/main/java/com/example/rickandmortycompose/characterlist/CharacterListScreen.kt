package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.rickandmortycompose.characterfilter.CharacterFilter
import com.example.rickandmortycompose.components.CharacterFilterSection
import com.example.rickandmortycompose.network.response.Character
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterListScreen(characterListViewModel: CharacterListViewModel = getViewModel(), onCharacterItemClicked: (Character) -> Unit) {
    val lazyCharacterItems = characterListViewModel.characterListPagingData.collectAsLazyPagingItems()
    val isExpanded = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        CharacterFilter(selectedFilters = emptyList(), isExpanded = isExpanded.value) {
            isExpanded.value = !isExpanded.value
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(lazyCharacterItems) { character ->
                val validCharacter = character ?: return@items
                CharacterListItem(character = validCharacter, onCharacterItemClicked = onCharacterItemClicked)
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
