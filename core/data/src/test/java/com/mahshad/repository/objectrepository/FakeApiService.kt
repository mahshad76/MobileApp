package com.mahshad.repository.objectrepository

import com.mahshad.network.ApiService
import com.mahshad.network.model.ObjectDto
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class FakeApiService() : ApiService {
    var shouldReturnError = false

    private fun fakeListResponse(): Response<List<ObjectDto>?> {
        return if (shouldReturnError) {
            Response.error(
                500,
                "Server error".toResponseBody("application/json".toMediaType())
            )
        } else {
            Response.success(listOf(ObjectDto.DEFAULT))
        }
    }

    private fun fakeObjectResponse(): Response<ObjectDto?> {
        return if (shouldReturnError) {
            Response.error(
                500,
                "Server error".toResponseBody("application/json".toMediaType())
            )
        } else {
            Response.success(ObjectDto.DEFAULT)
        }
    }

    override suspend fun getObjects(): Response<List<ObjectDto>?> = fakeListResponse()

    override suspend fun getObjectsById(ids: List<String>): Response<List<ObjectDto>?> =
        fakeListResponse()

    override suspend fun postAnObject(body: ObjectDto): Response<ObjectDto?> = fakeObjectResponse()

    override suspend fun deleteAnObject(id: String): Response<ResponseBody?> {
        return if (shouldReturnError) {
            Response.error(
                403,
                "Forbidden".toResponseBody("application/json".toMediaType())
            )
        } else {
            Response.success("Deleted $id".toResponseBody("text/plain".toMediaType()))
        }
    }

    override suspend fun partialUpdate(id: String, body: Map<String, Any>): Response<ObjectDto?> =
        fakeObjectResponse()

    override suspend fun update(id: String, body: ObjectDto): Response<ObjectDto?> =
        fakeObjectResponse()
}
