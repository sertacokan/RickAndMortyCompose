package com.example.rickandmortycompose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoChip(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    infoText: String
) {
    Surface(
        modifier = modifier.wrapContentSize(),
        shape = RoundedCornerShape(50),
        elevation = 8.dp,
        color = backgroundColor
    ) {
        Text(
            text = infoText,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
        )
    }
}

@Preview
@Composable
fun InfoChipPreview() {
    InfoChip(infoText = "Male")
}
