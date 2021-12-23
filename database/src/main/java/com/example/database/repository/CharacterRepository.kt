package com.example.database.repository

import androidx.paging.PagingSource
import com.example.database.character.CharacterDao
import com.example.database.character.CharacterEntity
import kotlinx.coroutines.flow.Flow

class CharacterRepository(private val characterDao: CharacterDao) {

    fun getCharacters(): PagingSource<Int, CharacterEntity> {
        return characterDao.getCharacters()
    }

    fun getCharacterById(characterId: Int): Flow<CharacterEntity> {
        return characterDao.getCharacterById(characterId = characterId)
    }

    fun filterCharacterByGender(gender: String): PagingSource<Int, CharacterEntity> {
        return characterDao.filterCharacterByGender(gender = gender)
    }

    fun filterCharacterByStatus(status: String): PagingSource<Int, CharacterEntity> {
        return characterDao.filterCharacterByStatus(status = status)
    }

    fun filterCharacter(gender: String, status: String): PagingSource<Int, CharacterEntity> {
        return characterDao.filterCharacter(gender = gender, status = status)
    }

    suspend fun favoriteCharacter(characterEntity: CharacterEntity) {
        return characterDao.favoriteCharacter(characterEntity = characterEntity)
    }

}
