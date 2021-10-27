package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.samples.CharacterProvider
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import com.example.rickandmortycompose.views.IconTextChip
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterListItem(
    modifier: Modifier = Modifier,
    character: Character,
    onCharacterItemClicked: (Character) -> Unit
) {
    val backgroundColor = if (character.isAlive) Color.White else Color.LightGray
    Card(
        modifier = modifier
            .padding(top = 8.dp)
            .clickable { onCharacterItemClicked(character) },
        backgroundColor = backgroundColor
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = character.name,
                    style = TextStyle(fontSize = 17.sp)
                )
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    crossAxisSpacing = 4.dp,
                    mainAxisSpacing = 4.dp
                ) {
                    IconTextChip(infoText = character.status.name)
                    if (character.type.isNotBlank()) {
                        IconTextChip(infoText = character.type)
                    }
                    IconTextChip(infoText = character.species)
                    IconTextChip(infoText = character.gender.name)
                }
            }
            Spacer(modifier = Modifier.width(2.dp))
            Image(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                painter = rememberImagePainter(data = character.imageUrl, builder = {
                    transformations(RoundedCornersTransformation(8f))
                }),
                contentDescription = stringResource(id = R.string.character_image_content_description),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Preview
@Composable
fun CharacterListItemPreview(
    @PreviewParameter(
        CharacterProvider::class,
        limit = 3
    ) character: Character
) {
    RickAndMortyComposeTheme {
        CharacterListItem(character = character, onCharacterItemClicked = {})
    }
}