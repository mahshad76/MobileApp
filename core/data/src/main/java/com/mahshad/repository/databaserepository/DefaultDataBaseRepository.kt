package com.mahshad.repository.databaserepository

import com.mahshad.database.DAO
import com.mahshad.model.data.Object
import jakarta.inject.Inject

class DefaultDataBaseRepository @Inject constructor(
    private val dao: DAO
) : DataBaseRepository {
    override suspend fun insert(mobileObject: Object) = dao.insert(mobileObject)
}