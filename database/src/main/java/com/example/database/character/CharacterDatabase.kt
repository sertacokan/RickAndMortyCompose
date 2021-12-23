package com.example.database.character

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.keys.RemoteKeyEntity
import com.example.database.keys.RemoteKeyDao

@Database(
    entities = [CharacterEntity::class, RemoteKeyEntity::class],
    exportSchema = false,
    version = 1
)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun remoteKeyDao(): RemoteKeyDao
    abstract fun characterDao(): CharacterDao
}
