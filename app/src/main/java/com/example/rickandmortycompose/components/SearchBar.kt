package com.example.rickandmortycompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChanged: (String) -> Unit,
    backgroundColor: Color = Color.LightGray,
    cursorColor: Color = Color.White,
    hint: String = "Search",
    hintColor: Color = Color.White,
    textStyle: TextStyle = TextStyle(fontSize = 17.sp),
    textColor: Color = cursorColor
) {
    TextField(
        value = query,
        onValueChange = onQueryChanged,
        leadingIcon = {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null,
                tint = Color.White
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor, RoundedCornerShape(4.dp)),
        placeholder = {
            Text(text = hint, style = TextStyle(color = hintColor))
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = cursorColor,
            textColor = textColor
        ),
        textStyle = textStyle,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go)
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(query = "", onQueryChanged = {})
}