package com.mahshad.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahshad.model.data.Object
import kotlinx.coroutines.flow.Flow

interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mobileObject: Object)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(mobileObjects: List<Object>)

    @Query("select * from Objects")
    fun getAll(): Flow<List<Object>>

    @Query("select * from Objects")
    fun getAllLively(): LiveData<List<Object>>

    @Query("select * from Objects where object_id=:mobileId")
    suspend fun searchById(mobileId: Int): Object

    @Query("DELETE FROM Objects WHERE object_id = :mobileId")
    suspend fun delete(mobileId: Int)

    @Query("DELETE FROM Objects")
    suspend fun deleteAll()
}