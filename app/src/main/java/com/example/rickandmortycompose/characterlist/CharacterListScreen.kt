package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.components.SearchBar
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterListScreen(characterListViewModel: CharacterListViewModel = getViewModel()) {
    val characters by characterListViewModel.characterList.collectAsState()
    val query by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        SearchBar(query = query, onQueryChanged = { query -> characterListViewModel.searchCharacter(query = query) })
        LazyColumn {
            items(characters) { character ->
                CharacterListItem(character = character) {}
            }
        }
    }
}

@Preview
@Composable
fun CharacterListScreenPreview() {
    CharacterListScreen()
}
