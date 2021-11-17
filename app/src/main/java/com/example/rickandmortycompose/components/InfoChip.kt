package com.example.rickandmortycompose.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalHospital
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.samples.CharacterProvider

@Composable
fun InfoChip(
    modifier: Modifier = Modifier,
    text: String,
    leadIcon: ImageVector? = null,
    unselectedBackgroundColor: Color = Color.LightGray,
    selectedBackgroundColor: Color = Color.White,
    contentColor: Color = Color.Black,
    textSize: TextUnit = 12.sp,
    isSelected: Boolean = false,
    textColor: Color = Color.DarkGray,
    backgroundShape: Shape = RoundedCornerShape(percent = 50),
    onSelectionChange: (String) -> Unit = { }
) {
    val backgroundColor by animateColorAsState(targetValue = if (isSelected) selectedBackgroundColor else unselectedBackgroundColor)
    Surface(
        modifier = modifier
            .wrapContentSize()
            .clickable { onSelectionChange(text) },
        elevation = 8.dp,
        shape = backgroundShape,
        color = backgroundColor,
        contentColor = contentColor
    ) {
        val innerComponentModifier = Modifier.padding(4.dp)
        Row(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadIcon != null) Icon(leadIcon, contentDescription = null)
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = textSize,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                ),
                modifier = innerComponentModifier,
                color = textColor
            )
        }
    }
}

@Preview
@Composable
fun InfoChipWithIconPreview(@PreviewParameter(CharacterProvider::class, limit = 1) character: Character) {
    val isSelected = remember { mutableStateOf(false) }
    InfoChip(
        text = character.species,
        leadIcon = Icons.Outlined.LocalHospital,
        isSelected = isSelected.value,
        onSelectionChange = { _ ->
        }
    )
}

@Preview
@Composable
fun InfoChipWithoutIconPreview(@PreviewParameter(CharacterProvider::class, limit = 1) character: Character) {
    val isSelected = remember { mutableStateOf(false) }
    InfoChip(
        text = character.species,
        isSelected = isSelected.value,
        onSelectionChange = { _ ->
        }
    )
}
