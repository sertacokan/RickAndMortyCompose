package com.example.rickandmortycompose.characterlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.components.InfoChip
import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.network.response.Status
import com.example.rickandmortycompose.samples.CharacterProvider
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterListItem(
    modifier: Modifier = Modifier,
    character: Character,
    onCharacterItemClicked: (Character) -> Unit
) {
    val backgroundColor = when (character.status) {
        Status.Dead -> Color.Red
        else -> Color.LightGray
    }

    Card(
        modifier = modifier
            .padding(vertical = 4.dp)
            .clickable { onCharacterItemClicked(character) }
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
                        .padding(top = 8.dp),
                    crossAxisSpacing = 4.dp,
                    mainAxisSpacing = 4.dp
                ) {
                    if (character.type.isNotBlank()) {
                        InfoChip(text = character.type)
                    }
                    InfoChip(text = character.species)
                    InfoChip(text = character.gender.name)
                }
            }
            Spacer(modifier = Modifier.width(2.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = rememberImagePainter(data = character.imageUrl, builder = {
                        transformations(RoundedCornersTransformation(8f))
                    }),
                    contentDescription = stringResource(id = R.string.character_image_content_description),
                    contentScale = ContentScale.FillBounds
                )
                if (!character.isAlive) {
                    Text(
                        modifier = Modifier
                            .rotate(45f)
                            .align(Alignment.Center),
                        text = character.status.name,
                        color = backgroundColor,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CharacterListItemPreview(@PreviewParameter(CharacterProvider::class) character: Character) {
    RickAndMortyComposeTheme {
        CharacterListItem(character = character, onCharacterItemClicked = {})
    }
}
