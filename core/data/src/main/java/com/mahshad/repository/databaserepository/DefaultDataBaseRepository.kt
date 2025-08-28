package com.mahshad.repository.databaserepository

import com.mahshad.model.data.Object
import jakarta.inject.Inject

class DefaultDataBaseRepository @Inject constructor(
) : DataBaseRepository {
    override suspend fun insert(mobileObject: Object) {
        TODO("Not yet implemented")
    }
}