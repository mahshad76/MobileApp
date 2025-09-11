package com.mahshad.network.retrofit

import com.mahshad.network.model.ObjectDto
import okhttp3.ResponseBody
import retrofit2.Response

interface NetworkDataSource {
    suspend fun getObjects(): Response<List<ObjectDto>?>

    suspend fun getObjectsById(ids: List<String>): Response<List<ObjectDto>?>

    suspend fun postAnObject(body: ObjectDto): Response<ObjectDto?>

    suspend fun deleteAnObject(id: String): Response<ResponseBody?>

    suspend fun partialUpdate(
        id: String,
        body: Map<String, Any>
    ): Response<ObjectDto?>

    suspend fun update(id: String, body: ObjectDto): Response<ObjectDto?>
}