package com.example.rickandmortycompose.characterdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterDetailScreen(
    characterDetailViewModel: CharacterDetailViewModel = getViewModel(),
    characterId: Int,
    onBackPress: () -> Unit = {}
) {
    //characterDetailViewModel.fetchCharacterDetail(characterId = characterId)

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackPress) {
                        Icon(imageVector = Icons.Outlined.ArrowBackIos, contentDescription = null)
                    }
                },
                actions = {

                },
                title = {
                    Text(text = "")
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {

        }
    }
}