package com.example.rickandmortycompose.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CharacterFilterSection(
    modifier: Modifier = Modifier,
    @StringRes sectionTitleRes: Int,
    sectionItems: List<String>,
    onSectionItemSelected: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = sectionTitleRes))
        FlowRow {
            for (item in sectionItems) {
                IconTextChip(infoText = item, onSelected = onSectionItemSelected)
            }
        }
    }
}