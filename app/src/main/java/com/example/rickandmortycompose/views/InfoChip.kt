package com.example.rickandmortycompose.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.samples.CharacterProvider

@Composable
fun InfoChip(
    modifier: Modifier = Modifier,
    infoText: String,
    chipBackgroundColor: Color = Color.White,
    chipTextColor: Color = Color.Black,
    alignment: Alignment = Alignment.Center,
    disabledChipBackgroundColor: Color = Color.Gray,
    isDisabled: Boolean = false
) {
    val backgroundColor = if (isDisabled) disabledChipBackgroundColor else chipBackgroundColor
    Surface(
        modifier = modifier.fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        color = backgroundColor,
        contentColor = chipTextColor
    ) {
        Box {
            Text(
                text = infoText, modifier = Modifier
                    .padding(4.dp)
                    .align(alignment)
            )
        }
    }
}

@Preview
@Composable
fun InfoChipPreview(@PreviewParameter(CharacterProvider::class, limit = 1) character: Character) {
    InfoChip(infoText = character.species)
}

@Preview
@Composable
fun InfoChipDisabledPreview(@PreviewParameter(CharacterProvider::class, limit = 1) character: Character) {
    InfoChip(infoText = character.species, isDisabled = true)
}