package com.example.rickandmortycompose.samples

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.database.character.CharacterEntity

class CharacterProvider : PreviewParameterProvider<CharacterEntity> {

    override val values: Sequence<CharacterEntity> = sequenceOf(
        CharacterEntity(
            id = 1,
            name = "Rick Sanchez",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            status = "Alive",
            specy = "Human",
            type = "",
            gender = "Male"
        ),
        CharacterEntity(
            id = 3,
            name = "Summer Smith",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
            status = "Alive",
            specy = "Human",
            type = "",
            gender = "Female"
        ),
        CharacterEntity(
            id = 6,
            name = "Abadango Cluster Princess",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/6.jpeg",
            status = "Unknown",
            specy = "Alien",
            type = "",
            gender = "Female"
        ),
        CharacterEntity(
            id = 7,
            name = "Abradolf Lincler",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/7.jpeg",
            status = "Unknown",
            specy = "Human",
            type = "Genetic experiment",
            gender = "Male"
        )
    )

    override val count: Int = values.count()
}
