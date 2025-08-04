package com.mahshad.repository

import android.util.Log
import com.mahshad.model.data.Object
import com.mahshad.network.ApiService
import com.mahshad.network.model.ObjectDto
import com.mahshad.network.model.toObject
import com.mahshad.threading.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import javax.inject.Inject

class DefaultObjectRepository @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ObjectRepository {
    override suspend fun getObjects(): List<Object>? {
        val a = apiService.getObjects()
        return withContext(ioDispatcher) {
            try {
                return@withContext apiService
                    .getObjects()
                    .map { objectDto ->
                        objectDto.toObject()
                    }
            } catch (e: Exception) {
                Log.e("TAG", "getObjects: an error has occurred, ${e.message}")
                return@withContext null
            }
        }
    }

    override suspend fun getObjectsById(ids: List<Int>): List<Object>? {
        return withContext(ioDispatcher) {
            try {
                return@withContext apiService.getObjectsById(ids)
                    .map { objectDto ->
                        objectDto.toObject()
                    }
            } catch (e: Exception) {
                Log.e("TAG", "getObjectsByIds: an error has occurred, ${e.message}")
                return@withContext null
            }
        }
    }

    override suspend fun postAnObject(body: ObjectDto): Object? {
        return withContext(ioDispatcher) {
            try {
                return@withContext apiService.postAnObject(body).toObject()
            } catch (e: Exception) {
                Log.e("TAG", "postAnObject: an error has occurred, ${e.message}")
                return@withContext null
            }
        }
    }

    override suspend fun deleteAnObject(id: Int): ResponseBody? {
        return withContext(ioDispatcher) {
            try {
                return@withContext apiService.deleteAnObject(id)
            } catch (e: Exception) {
                Log.e("TAG", "deleteAnObject: an error has occurred, ${e.message}")
                return@withContext null
            }
        }
    }

    override suspend fun partialUpdate(id: Int, body: Map<String, Any>): Object? {
        return withContext(ioDispatcher) {
            try {
                return@withContext apiService.partialUpdate(id, body).toObject()
            } catch (e: Exception) {
                Log.e("TAG", "partialUpdate: an error has occurred, ${e.message}")
                return@withContext null
            }
        }
    }

    override suspend fun update(id: Int, body: ObjectDto): Object? {
        return withContext(ioDispatcher) {
            try {
                return@withContext apiService.update(id, body).toObject()
            } catch (e: Exception) {
                Log.e("TAG", "update: an error has occurred, ${e.message}")
                return@withContext null
            }
        }
    }
}