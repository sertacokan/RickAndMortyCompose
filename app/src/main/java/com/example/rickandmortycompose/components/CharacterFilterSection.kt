package com.example.rickandmortycompose.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CharacterFilterSection(
    modifier: Modifier = Modifier,
    @StringRes sectionTitleRes: Int,
    sectionChips: List<String>,
    onSectionItemSelected: (String) -> Unit
) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = stringResource(id = sectionTitleRes), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(mainAxisSpacing = 8.dp) {
            for (chipText in sectionChips) {
                InfoChip(
                    text = chipText,
                    onSelectionChange = onSectionItemSelected,
                    backgroundShape = RoundedCornerShape(4.dp)
                )
            }
        }
    }
}

data class FilterSection(
    @StringRes val sectionTitleRes: Int,
    val sectionChips: List<String>
)

@Preview
@Composable
fun CharacterFilterSectionPreview() {
    CharacterFilterSection(
        sectionTitleRes = R.string.character_gender_title,
        sectionChips = listOf("female", "male", "genderless", "unknown"),
        onSectionItemSelected = {
        })
}