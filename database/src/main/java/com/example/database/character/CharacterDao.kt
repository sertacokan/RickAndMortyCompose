package com.example.database.character

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getCharacters(): PagingSource<Int, CharacterEntity>

    @Query("SELECT * FROM characters WHERE character_id = :characterId")
    fun getCharacterById(characterId: Int): CharacterEntity

    @Query("SELECT * FROM characters WHERE character_gender = :gender")
    fun filterCharacterByGender(gender: String): PagingSource<Int, CharacterEntity>

    @Query("SELECT * FROM characters WHERE character_status = :status")
    fun filterCharacterByStatus(status: String): PagingSource<Int, CharacterEntity>

    @Query("SELECT * FROM characters WHERE character_status = :status AND character_gender = :gender")
    fun filterCharacter(gender: String, status: String): PagingSource<Int, CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceCharacters(characterEntities: List<CharacterEntity>)

    @Update
    suspend fun favoriteCharacter(characterEntity: CharacterEntity)
}
