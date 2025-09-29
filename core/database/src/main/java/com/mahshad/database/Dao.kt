package com.mahshad.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mobileObject: ObjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(mobileObjects: List<ObjectEntity>)

    @Query("select * from Objects")
    fun getAll(): Flow<List<ObjectEntity>>

    @Query("select * from Objects")
    fun getAllLively(): LiveData<List<ObjectEntity>>

    @Query("select * from Objects where object_id=:mobileId")
    suspend fun searchById(mobileId: Int): ObjectEntity

    @Query("DELETE FROM Objects WHERE object_id = :mobileId")
    suspend fun delete(mobileId: Int)

    @Query("DELETE FROM Objects")
    suspend fun deleteAll()
}