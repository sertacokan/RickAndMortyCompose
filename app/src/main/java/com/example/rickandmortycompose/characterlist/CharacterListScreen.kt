package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.rickandmortycompose.components.SearchBar
import com.example.rickandmortycompose.network.response.Character

@Composable
fun CharacterListScreen(characters: List<Character>) {
    val (query, onValueChanged) = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth()) {
        SearchBar(query = query, onQueryChanged = onValueChanged)
        LazyColumn {
            items(characters) { character ->
                CharacterListItem(character = character, onCharacterItemClicked = {})
            }
        }
    }
}
