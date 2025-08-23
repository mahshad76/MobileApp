package com.mahshad.repository

import com.mahshad.model.data.Object
import com.mahshad.network.ApiService
import com.mahshad.network.model.ObjectDto
import com.mahshad.network.model.toObject
import okhttp3.ResponseBody
import javax.inject.Inject

class DefaultObjectRepository @Inject constructor(
    private val apiService: ApiService
) : ObjectRepository {
    override suspend fun getObjects(): Result<List<Object>> {
        return try {
            val response = apiService.getObjects()
            if (response.isSuccessful) {
                val listOfObjects = response.body()?.map { objectDto ->
                    objectDto.toObject()
                }
                if (listOfObjects != null) {
                    Result.Successful(listOfObjects)
                } else {
                    Result.Error(Exception("Response body is null"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Result.Error(
                    Exception(
                        "API call failed with code: " +
                                "${response.code()}, error: $errorBody"
                    )
                )
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getObjectsById(ids: List<Int>): Result<List<Object>> {
        return try {
            val response = apiService.getObjectsById(ids)
            if (response.isSuccessful) {
                val listOfObjects = response.body()?.map { objectDto ->
                    objectDto.toObject()
                }
                if (listOfObjects != null) {
                    Result.Successful(listOfObjects)
                } else {
                    Result.Error(Exception("Response body is null"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Result.Error(
                    Exception(
                        "API call failed with code: " +
                                "${response.code()}, error: $errorBody"
                    )
                )
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun postAnObject(body: ObjectDto): Result<Object> {
        return try {
            val response = apiService.postAnObject(body)
            if (response.isSuccessful) {
                val postedObject = response.body()?.toObject()
                if (postedObject != null) {
                    Result.Successful(postedObject)
                } else {
                    Result.Error(Exception("Response body is null"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Result.Error(
                    Exception(
                        "API call failed with code: " +
                                "${response.code()}, error: $errorBody"
                    )
                )
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun deleteAnObject(id: Int): Result<ResponseBody> {
        return try {
            val response = apiService.deleteAnObject(id)
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    Result.Successful(responseBody)
                } else {
                    Result.Error(Exception("Response body is null"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Result.Error(
                    Exception(
                        "API call failed with code: " +
                                "${response.code()}, error: $errorBody"
                    )
                )
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun partialUpdate(
        id: Int,
        body: Map<String, Any>
    ): Result<Object> {
        return try {
            val response = apiService.partialUpdate(id, body)
            if (response.isSuccessful) {
                val responseObject = response.body()?.toObject()
                if (responseObject != null) {
                    Result.Successful(responseObject)
                } else {
                    Result.Error(Exception("Response body is null"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Result.Error(
                    Exception(
                        "API call failed with code: " +
                                "${response.code()}, error: $errorBody"
                    )
                )
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun update(
        id: Int,
        body: ObjectDto
    ): Result<Object> {
        return try {
            val response = apiService.update(id, body)
            if (response.isSuccessful) {
                val responseObject = response.body()?.toObject()
                if (responseObject != null) {
                    Result.Successful(responseObject)
                } else {
                    Result.Error(Exception("Response body is null"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Result.Error(
                    Exception(
                        "API call failed with code: " +
                                "${response.code()}, error: $errorBody"
                    )
                )
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}