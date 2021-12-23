package com.example.database.keys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeyEntity(
    @PrimaryKey
    @ColumnInfo(name = "key_label")
    val label: String,
    @ColumnInfo(name = "key_value")
    val key: Int?
)
