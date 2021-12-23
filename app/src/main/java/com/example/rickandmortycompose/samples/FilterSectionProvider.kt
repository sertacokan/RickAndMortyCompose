package com.example.rickandmortycompose.samples

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.characterfilter.FilterSection
import com.example.rickandmortycompose.characterfilter.genderFilters
import com.example.rickandmortycompose.characterfilter.statusFilters

class FilterSectionProvider : PreviewParameterProvider<FilterSection> {
    override val values: Sequence<FilterSection>
        get() = sequenceOf(
            FilterSection(R.string.character_gender_title, genderFilters),
            FilterSection(R.string.character_status_title, statusFilters)
        )
}
