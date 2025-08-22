package com.mahshad.network.retrofit

import com.mahshad.network.model.ObjectDto
import okhttp3.ResponseBody
import retrofit2.Response

interface NetworkDataSource {
    suspend fun getObjects(): Response<List<ObjectDto>?>

    suspend fun getObjectsById(ids: List<Int>): Response<List<ObjectDto>?>

    suspend fun postAnObject(body: ObjectDto): Response<ObjectDto?>

    suspend fun deleteAnObject(id: Int): Response<ResponseBody?>

    suspend fun partialUpdate(
        id: Int,
        body: Map<String, Any>
    ): Response<ObjectDto?>

    suspend fun update(id: Int, body: ObjectDto): Response<ObjectDto?>
}