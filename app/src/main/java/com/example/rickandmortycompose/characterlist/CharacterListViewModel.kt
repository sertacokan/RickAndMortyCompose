package com.example.rickandmortycompose.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.database.repository.CharacterRepository
import com.example.paging.source.CharacterRemoteMediator
import com.example.rickandmortycompose.characterfilter.Filter
import com.example.rickandmortycompose.characterfilter.GenderFilter
import com.example.rickandmortycompose.characterfilter.StatusFilter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class, ExperimentalPagingApi::class)
class CharacterListViewModel(
    characterRemoteMediator: CharacterRemoteMediator,
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val characterStatus = MutableStateFlow("")
    private val characterGender = MutableStateFlow("")

    val characterList = Pager(
        config = PagingConfig(pageSize = 20),
        remoteMediator = characterRemoteMediator
    ) {
        characterRepository.getCharacters()
    }.flow.cachedIn(viewModelScope)

    fun updateFilter(filter: Filter) {
        when (filter) {
            is GenderFilter -> updateCharacterGenderFilter(filter)
            is StatusFilter -> updateCharacterStatusFilter(filter)
        }
    }

    private fun updateCharacterStatusFilter(status: StatusFilter) {
        characterStatus.value = status.name.lowercase(Locale.getDefault())
    }

    private fun updateCharacterGenderFilter(genderFilter: GenderFilter) {
        characterGender.value = genderFilter.name.lowercase(Locale.getDefault())
    }
}
