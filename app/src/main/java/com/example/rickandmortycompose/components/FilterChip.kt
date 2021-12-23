package com.example.rickandmortycompose.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.LocalHospital
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
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
import com.example.rickandmortycompose.characterfilter.Filter
import com.example.rickandmortycompose.characterfilter.GenderFilter
import com.example.network.response.Character
import com.example.rickandmortycompose.samples.CharacterProvider

@Composable
fun FilterChip(
    modifier: Modifier = Modifier,
    filter: Filter,
    leadIcon: ImageVector? = null,
    unselectedBackgroundColor: Color = Color.White,
    selectedBackgroundColor: Color = Color.LightGray,
    contentColor: Color = Color.Black,
    textSize: TextUnit = 12.sp,
    textColor: Color = Color.DarkGray,
    backgroundShape: Shape = RoundedCornerShape(percent = 50),
    isClosable: Boolean = false,
    closeIcon: ImageVector = Icons.Outlined.Close,
    onCloseClicked: (Filter) -> Unit = {},
    onSelectionChange: (Filter, Boolean) -> Unit = { _, _ -> }
) {
    val backgroundColor by animateColorAsState(targetValue = if (filter.isEnabled) selectedBackgroundColor else unselectedBackgroundColor)
    Surface(
        modifier = modifier
            .wrapContentSize()
            .toggleable(filter.isEnabled) { isToggled ->
                onSelectionChange(filter, isToggled)
            }
            .clip(backgroundShape),
        elevation = 8.dp,
        shape = backgroundShape,
        color = backgroundColor,
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadIcon != null) Icon(leadIcon, contentDescription = null)
            Text(
                text = filter.name,
                style = TextStyle(
                    fontSize = textSize,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(4.dp),
                color = textColor
            )

            if (isClosable) {
                Icon(
                    imageVector = closeIcon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(14.dp)
                        .clickable { onCloseClicked(filter) },
                    tint = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
fun InfoChipWithIconPreview(
    @PreviewParameter(
        CharacterProvider::class,
        limit = 1
    ) character: Character
) {
    val isSelected = remember { mutableStateOf(false) }
    val genderFilter = GenderFilter("Female")
    FilterChip(
        filter = genderFilter,
        leadIcon = Icons.Outlined.LocalHospital,
        onSelectionChange = { _, selected ->
            isSelected.value = selected
        }
    )
}

@Preview
@Composable
fun ClosableInfoChipWithIconPreview(
    @PreviewParameter(
        CharacterProvider::class,
        limit = 1
    ) character: Character
) {
    val isSelected = remember { mutableStateOf(false) }
    val genderFilter = GenderFilter("Female")

    FilterChip(
        filter = genderFilter,
        leadIcon = Icons.Outlined.LocalHospital,
        isClosable = true,
        onSelectionChange = { _, selected ->
            isSelected.value = selected
        }
    )
}

@Preview
@Composable
fun InfoChipWithoutIconPreview(
    @PreviewParameter(
        CharacterProvider::class,
        limit = 1
    ) character: Character
) {
    val isSelected = remember { mutableStateOf(false) }
    val genderFilter = GenderFilter("Female")

    FilterChip(
        filter = genderFilter,
        onSelectionChange = { _, selected ->
            isSelected.value = selected
        }
    )
}
