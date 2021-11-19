package com.example.rickandmortycompose.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortycompose.network.CharacterRepository
import com.example.rickandmortycompose.network.response.Character
import java.lang.Exception

class CharacterDataSource(private val characterRepository: CharacterRepository, private val query: String? = null) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition = anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val pageNumber = params.key ?: 1
            val characterResponse = if (query.isNullOrBlank()) {
                characterRepository.fetchCharacterList(pageNumber = pageNumber)
            } else {
                characterRepository.fetchCharacterListByName(name = query, pageNumber = pageNumber)
            }
            val nextPageNumber = if (characterResponse.info.next != null) pageNumber + 1 else null
            val previousPageNumber = if (characterResponse.info.prev != null) pageNumber - 1 else null
            LoadResult.Page(data = characterResponse.results, prevKey = previousPageNumber, nextKey = nextPageNumber)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}