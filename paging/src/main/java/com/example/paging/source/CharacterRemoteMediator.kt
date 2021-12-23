package com.example.paging.source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.database.character.CharacterDatabase
import com.example.database.character.CharacterEntity
import com.example.database.keys.RemoteKeyEntity
import com.example.network.CharacterService
import com.example.network.response.Character
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator(
    private val characterService: CharacterService,
    private val characterDatabase: CharacterDatabase
) : RemoteMediator<Int, CharacterEntity>() {

    private val remoteKeyDao = characterDatabase.remoteKeyDao()
    private val characterDao = characterDatabase.characterDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {
            val remoteKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = remoteKeyDao.remoteKeyByLabel(label = KEY_LABEL)
                    if (remoteKey != null && remoteKey.key == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    remoteKey
                }
            }
            val pageNumber = remoteKey?.key ?: INITIAL_KEY
            val response = characterService.fetchCharacterList(pageNumber = pageNumber)
            val isEndOfThePage = response.info.next == null

            val nextKey = if (!isEndOfThePage) pageNumber + 1 else null
            val entities = response.results.map { character ->
                CharacterEntity(
                    id = character.id,
                    name = character.name,
                    imageUrl = character.imageUrl,
                    status = character.status.name,
                    specy = character.species,
                    type = character.type,
                    gender = character.gender.name
                )
            }
            characterDatabase.withTransaction {
                remoteKeyDao.insertOrReplace(
                    RemoteKeyEntity(remoteKey?.label ?: KEY_LABEL, nextKey)
                )
                characterDao.insertOrReplaceCharacters(entities)
            }

            MediatorResult.Success(endOfPaginationReached = isEndOfThePage)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        }
    }

    private companion object {
        private const val INITIAL_KEY = 1
        private const val KEY_LABEL = "character_page_number"
    }
}
