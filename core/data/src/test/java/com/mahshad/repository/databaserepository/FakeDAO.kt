package com.mahshad.repository.databaserepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mahshad.database.DAO
import com.mahshad.database.ObjectEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FakeDAO : DAO {
    val listOfObjects: MutableList<ObjectEntity> =
        emptyList<ObjectEntity>() as MutableList<ObjectEntity>
    val _liveDataOfObjects: MutableLiveData<List<ObjectEntity>> = MutableLiveData(listOfObjects)
    val liveDataOfObjects: LiveData<List<ObjectEntity>> = _liveDataOfObjects
    val _flowOfObjects: MutableStateFlow<List<ObjectEntity>> = MutableStateFlow(listOfObjects)
    val flowOfObjects: StateFlow<List<ObjectEntity>> = _flowOfObjects

    fun refreshReactiveStreams() {
        _flowOfObjects.value = listOfObjects
        _liveDataOfObjects.postValue(listOfObjects)
    }

    override suspend fun insert(mobileObject: ObjectEntity) {
        listOfObjects.add(mobileObject)
        refreshReactiveStreams()
    }

    override suspend fun insertAll(mobileObjects: List<ObjectEntity>) {
        listOfObjects.addAll(mobileObjects)
        refreshReactiveStreams()
    }

    override fun getAll(): Flow<List<ObjectEntity>> {
        return flowOfObjects
    }

    override fun getAllLively(): LiveData<List<ObjectEntity>> {
        return liveDataOfObjects
    }

    override suspend fun searchById(mobileId: Int): ObjectEntity {
        return listOfObjects.first { it.id.toInt() == mobileId }
    }

    override suspend fun delete(mobileId: Int) {
        listOfObjects.removeIf { it.id.toInt() == mobileId }
        refreshReactiveStreams()
    }

    override suspend fun deleteAll() {
        listOfObjects.clear()
    }
}