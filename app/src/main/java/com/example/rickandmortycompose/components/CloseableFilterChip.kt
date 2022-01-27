package com.example.rickandmortycompose.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.rickandmortycompose.characterfilter.Filter

@Composable
fun CloseableFilterChip(
    modifier: Modifier = Modifier,
    filter: Filter,
    leadIcon: ImageVector? = null,
    unselectedBackgroundColor: Color = MaterialTheme.colors.surface,
    selectedBackgroundColor: Color = Color.LightGray,
    contentColor: Color = Color.Black,
    textSize: TextUnit = 12.sp,
    textColor: Color = Color.DarkGray,
    backgroundShape: Shape = MaterialTheme.shapes.small,
    closeIcon: ImageVector = Icons.TwoTone.Close,
    onCloseClicked: (Filter) -> Unit = {}
) {
    FilterChip(
        modifier = modifier,
        filter = filter,
        leadIcon = leadIcon,
        unselectedBackgroundColor = unselectedBackgroundColor,
        selectedBackgroundColor = selectedBackgroundColor,
        contentColor = contentColor,
        textSize = textSize,
        textColor = textColor,
        backgroundShape = backgroundShape,
        isClosable = true,
        isToggleable = false,
        closeIcon = closeIcon,
        onCloseClicked = onCloseClicked,
        onSelectionChange = { _, _ -> }
    )
}
