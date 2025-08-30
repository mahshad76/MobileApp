package com.mahshad.repository.databaserepository

import com.mahshad.model.data.Object
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    suspend fun insert(mobileObject: Object)
    fun selectAll(): Flow<List<Object>>
}