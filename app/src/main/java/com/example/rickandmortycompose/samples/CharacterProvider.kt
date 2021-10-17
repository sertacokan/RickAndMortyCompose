package com.example.rickandmortycompose.samples

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.rickandmortycompose.network.response.Character
import com.example.rickandmortycompose.network.response.Gender
import com.example.rickandmortycompose.network.response.Status

class CharacterProvider : PreviewParameterProvider<Character> {

    override val values: Sequence<Character> = sequenceOf(
        Character(
            id = 1,
            name = "Rick Sanchez",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            status = Status.Alive,
            species = "Human",
            type = "",
            gender = Gender.Male,
            url = "https://rickandmortyapi.com/api/character/1"
        ),
        Character(
            id = 2,
            name = "Morty Smith",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            status = Status.Alive,
            species = "Human",
            type = "",
            gender = Gender.Male,
            url = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
        ),
        Character(
            id = 3,
            name = "Summer Smith",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
            status = Status.Alive,
            species = "Human",
            type = "",
            gender = Gender.Female,
            url = "https://rickandmortyapi.com/api/character/3"
        ),
        Character(
            id = 4,
            name = "Beth Smith",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/4.jpeg",
            status = Status.Alive,
            species = "Human",
            type = "",
            gender = Gender.Female,
            url = "https://rickandmortyapi.com/api/character/4"
        ),
        Character(
            id = 5,
            name = "Jerry Smith",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
            status = Status.Alive,
            species = "Human",
            type = "",
            gender = Gender.Male,
            url = "https://rickandmortyapi.com/api/character/5"
        ),
        Character(
            id = 6,
            name = "Abadango Cluster Princess",
            imageUrl = "\"https://rickandmortyapi.com/api/character/6",
            status = Status.Unknown,
            species = "Human",
            type = "",
            gender = Gender.Male,
            url = "https://rickandmortyapi.com/api/character/6"
        ),
        Character(
            id = 7,
            name = "Abradolf Lincler",
            imageUrl = "https://rickandmortyapi.com/api/character/7",
            status = Status.Unknown,
            species = "Human",
            type = "Genetic experiment",
            gender = Gender.Male,
            url = "https://rickandmortyapi.com/api/character/7"
        )
    )

    override val count: Int = values.count()
}