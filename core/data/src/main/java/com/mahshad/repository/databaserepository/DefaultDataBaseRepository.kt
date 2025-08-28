package com.mahshad.repository.databaserepository

import com.mahshad.database.DAO
import com.mahshad.database.ObjectEntity
import com.mahshad.database.toObject
import com.mahshad.model.data.Object
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DefaultDataBaseRepository @Inject constructor(
    private val dao: DAO
) : DataBaseRepository {
    override suspend fun insert(mobileObject: Object) {
        val objectEntity = ObjectEntity(
            name = mobileObject.name ?: " ",
            id = mobileObject.id ?: " ",
            data = mobileObject.data
        )
        dao.insert(objectEntity)
    }

    override fun selectAll(): Flow<List<Object>> {
        return dao.getAll().map { objectEntities: List<ObjectEntity> ->
            objectEntities.map { objectEntity: ObjectEntity ->
                objectEntity.toObject()
            }
        }
    }
}