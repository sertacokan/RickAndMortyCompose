package com.example.rickandmortycompose.characterdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.network.response.Character
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CharacterDetailScreen(
    characterId: Int,
    onBackPress: () -> Unit = {},
    onFavoriteClick: (Character?) -> Unit = {}
) {
    val characterDetailViewModel: CharacterDetailViewModel = getViewModel {
        parametersOf(characterId)
    }
    val character by characterDetailViewModel.characterInfo.observeAsState()

    Scaffold(
        topBar = {
            CharacterDetailFavoriteTopAppBar(
                characterInfo = character,
                onBackPress = onBackPress,
                onFavoriteClick = onFavoriteClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier =
            Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(4.dp),
                painter = rememberImagePainter(data = character?.imageUrl),
                contentDescription = stringResource(id = R.string.character_image_content_description)
            )
            Text(
                text = character?.name.orEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
        }
    }
}

@Composable
private fun CharacterDetailFavoriteTopAppBar(
    characterInfo: Character?,
    isFavorite: Boolean = false,
    onBackPress: () -> Unit = {},
    onFavoriteClick: (Character?) -> Unit = {}
) {
    val favoriteIcon = if (isFavorite) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBackIos,
                    contentDescription = stringResource(id = R.string.character_back_button_content_description)
                )
            }
        },
        actions = {
            IconButton(onClick = { onFavoriteClick(characterInfo) }) {
                Icon(
                    imageVector = favoriteIcon,
                    contentDescription = stringResource(id = R.string.character_favorite_button_content_description)
                )
            }
        },
        title = {
            Text(text = stringResource(id = R.string.character_detail_title))
        }
    )
}

@Preview
@Composable
fun CharacterDetailTopAppBarPreview() {
    CharacterDetailFavoriteTopAppBar(characterInfo = null)
}