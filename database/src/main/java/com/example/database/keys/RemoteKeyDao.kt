package com.example.database.keys

import androidx.room.*

@Dao
interface RemoteKeyDao {

    @Query("SELECT * FROM remote_keys WHERE key_label = :label")
    suspend fun remoteKeyByLabel(label: String): RemoteKeyEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(remoteKeyEntity: RemoteKeyEntity)

    @Query("DELETE FROM remote_keys WHERE key_label = :label")
    suspend fun deleteKeyByLabel(label: String)
}
