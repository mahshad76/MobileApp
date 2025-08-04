package com.mahshad.network.retrofit

import com.mahshad.network.model.ObjectDto
import okhttp3.ResponseBody

interface NetworkDataSource {
    suspend fun getObjects(): List<ObjectDto>

    suspend fun getObjectsById(ids: List<Int>): List<ObjectDto>

    suspend fun postAnObject(body: ObjectDto): ObjectDto

    suspend fun deleteAnObject(id: Int): ResponseBody

    suspend fun partialUpdate(
        id: Int,
        body: Map<String, Any>
    ): ObjectDto

    suspend fun update(id: Int, body: ObjectDto): ObjectDto
}