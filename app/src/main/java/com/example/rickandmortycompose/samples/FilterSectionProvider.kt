package com.example.rickandmortycompose.samples

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.rickandmortycompose.components.FilterSection

class FilterSectionProvider : PreviewParameterProvider<FilterSection> {
    override val values: Sequence<FilterSection>
        get() = FilterSection.sections.asSequence()
}