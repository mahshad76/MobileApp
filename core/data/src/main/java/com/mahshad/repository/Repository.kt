package com.mahshad.repository

import com.mahshad.model.data.Object
import com.mahshad.network.model.ObjectDto
import okhttp3.ResponseBody

interface Repository {
    suspend fun getObjects(): List<Object>?

    suspend fun getObjectsById(ids: List<Int>): List<Object>?

    suspend fun postAnObject(body: ObjectDto): Object?

    suspend fun deleteAnObject(id: Int): ResponseBody?

    suspend fun partialUpdate(id: Int, body: Map<String, Any>): Object?

    suspend fun update(id: Int, body: ObjectDto): Object?
}

