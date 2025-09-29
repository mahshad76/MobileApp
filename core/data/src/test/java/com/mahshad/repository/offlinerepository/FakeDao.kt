package com.mahshad.repository.offlinerepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mahshad.database.Dao
import com.mahshad.database.ObjectEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeDao : Dao {

    val database: MutableList<ObjectEntity> = mutableListOf(ObjectEntity.DEFAULT)

    override suspend fun insert(mobileObject: ObjectEntity) {
        database.add(mobileObject)
    }

    override suspend fun insertAll(mobileObjects: List<ObjectEntity>) {
        database.addAll(mobileObjects)
    }

    override fun getAll(): Flow<List<ObjectEntity>> {
        return flow {
            emit(database)
        }
    }

    override fun getAllLively(): LiveData<List<ObjectEntity>> {
        return MutableLiveData(database)

    }

    override suspend fun searchById(mobileId: Int): ObjectEntity {
        return ObjectEntity.DEFAULT
    }

    override suspend fun delete(mobileId: Int) {
    }

    override suspend fun deleteAll() {
    }
}