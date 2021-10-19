package com.example.rickandmortycompose.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp

@Composable
fun EqualSizedItemRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // measurables is the list of children that need to be measured and constraints are the constraints from the parent.
    Layout(content = content, modifier = modifier) { measurableList, constraints ->
        val itemCount = measurableList.size
        val spaceWidthPx = 5.dp.roundToPx()
        val totalSpace = (itemCount - 1) * spaceWidthPx
        val itemSize = (constraints.maxWidth - totalSpace) / itemCount

        val childConstraint = constraints.copy(maxWidth = itemSize, minWidth = 0)

        // TODO : Fix width issue and show background color
        val placeableList = measurableList.map { measurable -> measurable.measure(childConstraint) }

        layout(constraints.maxWidth, constraints.minHeight) {
            var startX = 0
            placeableList.forEachIndexed { position, placeable ->
                placeable.placeRelative(x = startX, y = 0)
                startX += if (position != placeableList.lastIndex) placeable.width + spaceWidthPx else placeable.width
            }
        }
    }
}