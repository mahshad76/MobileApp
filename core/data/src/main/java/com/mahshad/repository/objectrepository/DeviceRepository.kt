package com.mahshad.repository.objectrepository

import com.mahshad.model.data.Object
import com.mahshad.network.model.ObjectDto
import okhttp3.ResponseBody

//TODO document for the interface
interface DeviceRepository {
    suspend fun getObjects(): Result<List<Object>>

    suspend fun getObjectsById(ids: List<Int>): Result<List<Object>>

    suspend fun postAnObject(body: ObjectDto): Result<Object>

    suspend fun deleteAnObject(id: Int): Result<ResponseBody>

    suspend fun partialUpdate(id: Int, body: Map<String, Any>): Result<Object>

    suspend fun update(id: Int, body: ObjectDto): Result<Object>
}