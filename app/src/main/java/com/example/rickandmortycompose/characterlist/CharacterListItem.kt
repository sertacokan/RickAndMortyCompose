package com.example.rickandmortycompose.characterlist

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.database.character.CharacterEntity
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.components.InfoChip
import com.example.rickandmortycompose.samples.CharacterProvider
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterListItem(
    modifier: Modifier = Modifier,
    character: CharacterEntity,
    onCharacterItemClicked: (CharacterEntity) -> Unit
) {
    val backgroundColor = when (character.status) {
        "Dead" -> Color.Red
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
                    style = TextStyle(fontSize = 17.sp, color = MaterialTheme.colors.onSurface)
                )
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    crossAxisSpacing = 4.dp,
                    mainAxisSpacing = 4.dp
                ) {
                    if (character.type.isNotBlank()) {
                        InfoChip(infoText = character.type)
                    }
                    InfoChip(infoText = character.specy)
                    InfoChip(infoText = character.gender)
                }
            }
            Spacer(modifier = Modifier.width(2.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    painter = rememberImagePainter(data = character.imageUrl, builder = {
                        transformations(RoundedCornersTransformation(8f))
                    }),
                    contentDescription = stringResource(id = R.string.character_image_content_description),
                    contentScale = ContentScale.FillBounds,
                )
                if (!character.isAlive) {
                    Text(
                        modifier = Modifier
                            .rotate(45f)
                            .align(Alignment.Center),
                        text = character.status,
                        color = backgroundColor,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
fun CharacterListItemPreview(
    @PreviewParameter(
        CharacterProvider::class,
        limit = 1
    ) character: CharacterEntity
) {
    RickAndMortyComposeTheme {
        CharacterListItem(character = character, onCharacterItemClicked = {})
    }
}
