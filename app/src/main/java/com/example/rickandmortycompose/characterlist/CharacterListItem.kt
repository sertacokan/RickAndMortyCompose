package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.samples.CharacterProvider
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import com.example.rickandmortycompose.views.EqualSizedItemRow
import com.example.rickandmortycompose.views.InfoChip

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterListItem(
    modifier: Modifier = Modifier,
    character: Character,
    onCharacterItemClicked: (Character) -> Unit
) {
    Card(modifier = modifier
        .padding(4.dp)
        .clickable { onCharacterItemClicked(character) }) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = character.name,
                    style = TextStyle(fontSize = 17.sp)
                )
                EqualSizedItemRow(modifier = Modifier.padding(4.dp)) {
                    InfoChip(
                        infoText = character.status.name,
                        isDisabled = !character.isAlive
                    )
                    InfoChip(
                        infoText = character.type,
                        isDisabled = !character.isAlive
                    )
                    InfoChip(infoText = character.species)
                    InfoChip(infoText = character.gender.name)
                }
            }
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                modifier = Modifier.weight(1f),
                painter = rememberImagePainter(data = character.imageUrl, builder = {
                    placeholder(R.drawable.ic_launcher_background)
                }),
                contentDescription = stringResource(id = R.string.chacter_image_content_description),
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