package com.example.rickandmortycompose.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CloseableFilterChip(
    modifier: Modifier = Modifier,
    text: String,
    leadIcon: ImageVector? = null,
    unselectedBackgroundColor: Color = Color.White,
    selectedBackgroundColor: Color = Color.LightGray,
    contentColor: Color = Color.Black,
    textSize: TextUnit = 12.sp,
    isSelected: Boolean = false,
    textColor: Color = Color.DarkGray,
    backgroundShape: Shape = RoundedCornerShape(size = 4.dp),
    closeIcon: ImageVector = Icons.TwoTone.Close,
    onCloseClicked: (String) -> Unit = {},
    onSelectionChange: (String) -> Unit = {}
) {
    InfoChip(
        modifier = modifier,
        text = text,
        leadIcon = leadIcon,
        unselectedBackgroundColor = unselectedBackgroundColor,
        selectedBackgroundColor = selectedBackgroundColor,
        contentColor = contentColor,
        textSize = textSize,
        isSelected = isSelected,
        textColor = textColor,
        backgroundShape = backgroundShape,
        isClosable = true,
        closeIcon = closeIcon,
        onCloseClicked = onCloseClicked,
        onSelectionChange = onSelectionChange
    )
}