package com.example.rickandmortycompose.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalHospital
import androidx.compose.material.icons.twotone.LocalHospital
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun IconTextChip(
    modifier: Modifier = Modifier,
    infoText: String,
    propertyIcon: ImageVector = Icons.TwoTone.LocalHospital,
    backgroundColor: Color = Color.White,
    propertyTextColor: Color = Color.Black,
    titleTextSize: TextUnit = 12.sp
) {
    Surface(
        modifier = modifier.wrapContentSize(),
        elevation = 8.dp,
        shape = RoundedCornerShape(percent = 50),
        color = backgroundColor,
        contentColor = propertyTextColor
    ) {
        val innerComponentModifier = Modifier.padding(4.dp)
        Row(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(propertyIcon, contentDescription = null)
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = infoText,
                style = TextStyle(fontSize = titleTextSize, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold),
                modifier = innerComponentModifier,
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun CharacterPropertyBannerPreview(@PreviewParameter(CharacterProvider::class, limit = 1) character: Character) {
    IconTextChip(
        infoText = character.species,
        propertyIcon = Icons.Outlined.LocalHospital
    )
}
