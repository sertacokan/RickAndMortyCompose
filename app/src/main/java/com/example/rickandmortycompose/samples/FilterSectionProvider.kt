package com.example.rickandmortycompose.samples

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.rickandmortycompose.characterfilter.FilterSection
import com.example.rickandmortycompose.characterfilter.filterSections

class FilterSectionProvider : PreviewParameterProvider<FilterSection> {
    override val values: Sequence<FilterSection>
        get() = filterSections.asSequence()
}
