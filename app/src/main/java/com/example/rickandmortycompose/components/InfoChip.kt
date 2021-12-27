package com.example.rickandmortycompose.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
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
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme

@Composable
fun InfoChip(
    modifier: Modifier = Modifier,
    infoText: String
) {
    Surface(
        modifier = modifier.wrapContentSize(),
        shape = RoundedCornerShape(50),
        elevation = 8.dp
    ) {
        Text(
            text = infoText,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
fun InfoChipPreview() {
    RickAndMortyComposeTheme {
        InfoChip(infoText = "Male")
    }
}
