package com.mahshad.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mobileObject: Entity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(mobileObjects: List<Entity>)

    @Query("select * from Objects")
    fun getAll(): Flow<List<Entity>>

    @Query("select * from Objects")
    fun getAllLively(): LiveData<List<Entity>>

    @Query("select * from Objects where object_id=:mobileId")
    suspend fun searchById(mobileId: Int): Entity

    @Query("DELETE FROM Objects WHERE object_id = :mobileId")
    suspend fun delete(mobileId: Int)

    @Query("DELETE FROM Objects")
    suspend fun deleteAll()
}