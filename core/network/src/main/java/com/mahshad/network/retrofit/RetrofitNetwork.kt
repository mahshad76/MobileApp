package com.mahshad.network.retrofit

import com.mahshad.network.ApiService
import com.mahshad.network.model.ObjectDto
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RetrofitNetwork @Inject constructor(private val apiService: ApiService) : NetworkDataSource {
    override suspend fun getObjects(): Response<List<ObjectDto>?> =
        apiService.getObjects()

    override suspend fun getObjectsById(ids: List<Int>) =
        apiService.getObjectsById(ids)

    override suspend fun postAnObject(body: ObjectDto) =
        apiService.postAnObject(body)

    override suspend fun deleteAnObject(id: Int): Response<ResponseBody> =
        apiService.deleteAnObject(id)

    override suspend fun partialUpdate(id: Int, body: Map<String, Any>): Response<ObjectDto> =
        apiService.partialUpdate(id, body)

    override suspend fun update(id: Int, body: ObjectDto): Response<ObjectDto> =
        apiService.update(id, body)
}