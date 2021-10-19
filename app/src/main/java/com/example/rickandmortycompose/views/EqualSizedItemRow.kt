package com.example.rickandmortycompose.views

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun EqualSizedItemRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurableList, constraints ->
        val spaceWidthPx = 5.dp.roundToPx()
        val minItemWidthPx = (100.dp).roundToPx()
        val itemCount = measurableList.size
        val totalSpace = (itemCount - 1) * spaceWidthPx
        val itemSize = (constraints.maxWidth - totalSpace) / itemCount
        val minWidthPx = min(itemSize, minItemWidthPx)
        val placeableList = measurableList.map { measurable ->
            measurable.measure(constraints.copy(minWidth = minWidthPx, maxWidth = minWidthPx)) // TODO : Fix width issue and show background color
        }
        layout(constraints.maxWidth, constraints.minHeight) {
            var startX = 0
            placeableList.forEachIndexed { position, placeable ->
                placeable.place(x = startX, y = 0)
                startX += if (position != placeableList.lastIndex) placeable.width + spaceWidthPx else placeable.width
            }
        }
    }
}