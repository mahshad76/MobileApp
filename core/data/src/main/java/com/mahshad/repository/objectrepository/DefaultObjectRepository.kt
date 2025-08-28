package com.mahshad.repository.objectrepository

import com.mahshad.model.data.Object
import com.mahshad.network.ApiService
import com.mahshad.network.model.ObjectDto
import com.mahshad.network.model.toObject
import com.mahshad.repository.objectrepository.ObjectRepository
import com.mahshad.repository.objectrepository.Result
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

fun <T, K> assessResponse(response: Response<T?>, operation: (T) -> K): Result<K> =
    if (response.isSuccessful) {
        response.body()?.let { body ->
            try {
                val transformedData = operation(body)
                Result.Successful(transformedData)
            } catch (e: Exception) {
                Result.Error(e)
            }
        } ?: Result.Error(Exception("Response body is null"))
    } else {
        val errorBody = response.errorBody()?.string()
        Result.Error(
            Exception(
                "API call failed with code: ${response.code()}, error: $errorBody"
            )
        )
    }

class DefaultObjectRepository @Inject constructor(
    private val apiService: ApiService
) : ObjectRepository {
    override suspend fun getObjects(): Result<List<Object>> {
        val response = apiService.getObjects()
        return assessResponse(response, { input: List<ObjectDto> ->
            input.map { objectDto ->
                objectDto.toObject()
            }
        })
    }

    override suspend fun getObjectsById(ids: List<Int>): Result<List<Object>> {
        val response = apiService.getObjectsById(ids)
        return assessResponse(response, { input: List<ObjectDto> ->
            input.map { objectDto ->
                objectDto.toObject()
            }
        })
    }

    override suspend fun postAnObject(body: ObjectDto): Result<Object> {
        val response = apiService.postAnObject(body)
        return assessResponse(response, { input: ObjectDto -> input.toObject() })
    }

    override suspend fun deleteAnObject(id: Int): Result<ResponseBody> {
        val response = apiService.deleteAnObject(id)
        return assessResponse(response, { it })
    }

    override suspend fun partialUpdate(
        id: Int,
        body: Map<String, Any>
    ): Result<Object> {
        val response = apiService.partialUpdate(id, body)
        return assessResponse(response, { input: ObjectDto -> input.toObject() })
    }

    override suspend fun update(
        id: Int,
        body: ObjectDto
    ): Result<Object> {
        val response = apiService.update(id, body)
        return assessResponse(response, { input: ObjectDto -> input.toObject() })
    }
}