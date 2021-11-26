package com.example.rickandmortycompose.characterdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterDetailScreen(
    characterId: Int,
    characterDetailViewModel: CharacterDetailViewModel = getViewModel()
) {
    //characterDetailViewModel.fetchCharacterDetail(characterId = characterId)

    Scaffold(
        topBar = {
            TopAppBar() {

            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {

        }
    }
}