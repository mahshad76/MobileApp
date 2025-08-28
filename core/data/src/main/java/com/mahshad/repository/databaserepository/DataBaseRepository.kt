package com.mahshad.repository.databaserepository

import com.mahshad.model.data.Object

interface DataBaseRepository {
    suspend fun insert(mobileObject: Object)
}