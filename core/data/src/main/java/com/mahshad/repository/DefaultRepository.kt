package com.mahshad.repository

import android.util.Log
import com.mahshad.model.data.Object
import com.mahshad.network.ApiService
import com.mahshad.network.model.ObjectDto
import com.mahshad.network.model.toObject
import okhttp3.ResponseBody
import javax.inject.Inject

class DefaultRepository @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun getObjects(): List<Object>? {
        try {
            val response = apiService.getObjects()
            if (response.isSuccessful) {
                return response.body()?.let {
                    it.map { objectDto ->
                        objectDto.toObject()
                    }
                } ?: emptyList()

            } else {
                Log.d("TAG", "getObjects is not successful")
                return null

            }
        } catch (e: Exception) {
            Log.e("TAG", "getObjects: an error has occurred, ${e.message}")
            return null
        }
    }

    override suspend fun getObjectsById(ids: List<Int>): List<Object>? {
        try {
            val response = apiService.getObjectsById(ids)
            if (response.isSuccessful) {
                return response.body()?.let {
                    it.map { objectDto ->
                        objectDto.toObject()
                    }
                } ?: emptyList()

            } else {
                Log.d("TAG", "getObjectsByIds is not successful")
                return null

            }
        } catch (e: Exception) {
            Log.e("TAG", "getObjectsByIds: an error has occurred, ${e.message}")
            return null
        }
    }

    override suspend fun postAnObject(body: ObjectDto): Object? {
        try {
            val response = apiService.postAnObject(body)
            if (response.isSuccessful) {
                return response.body()?.toObject()
            } else {
                Log.d("TAG", "postAnObject is not successful")
                return null
            }

        } catch (e: Exception) {
            Log.e("TAG", "postAnObject: an error has occurred, ${e.message}")
            return null
        }
    }

    override suspend fun deleteAnObject(id: Int): ResponseBody? {
        try {
            val response = apiService.deleteAnObject(id)
            if (response.isSuccessful) {
                return response.body()
            } else {
                Log.d("TAG", "deleteAnObject is not successful")
                return null
            }
        } catch (e: Exception) {
            Log.e("TAG", "deleteAnObject: an error has occurred, ${e.message}")
            return null
        }
    }

    override suspend fun partialUpdate(id: Int, body: Map<String, Any>): Object? {
        try {
            val response = apiService.partialUpdate(id, body)
            if (response.isSuccessful) {
                return response.body()?.toObject()
            } else {
                Log.d("TAG", "partialUpdate is not successful")
                return null
            }
        } catch (e: Exception) {
            Log.e("TAG", "partialUpdate: an error has occurred, ${e.message}")
            return null
        }
    }

    override suspend fun update(id: Int, body: ObjectDto): Object? {
        try {
            val response = apiService.update(id, body)
            if (response.isSuccessful) {
                return response.body()?.toObject()
            } else {
                Log.d("TAG", "update is not successful")
                return null
            }
        } catch (e: Exception) {
            Log.e("TAG", "update: an error has occurred, ${e.message}")
            return null
        }
    }

}