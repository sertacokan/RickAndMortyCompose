package com.example.database.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    @ColumnInfo(name = "character_id")
    val id: Int,
    @ColumnInfo(name = "character_name")
    val name: String,
    @ColumnInfo(name = "character_image_url")
    val imageUrl: String,
    @ColumnInfo(name = "character_status")
    val status: String,
    @ColumnInfo(name = "character_specy")
    val specy: String,
    @ColumnInfo(name = "character_type")
    val type: String,
    @ColumnInfo(name = "character_gender")
    val gender: String,
    @ColumnInfo(name = "is_favorite", defaultValue = "0")
    val isFavorite: Int = 0
) {
    val isAlive: Boolean get() = status == "Alive"
}
