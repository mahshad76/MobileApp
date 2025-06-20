package com.mahshad.repository

import android.util.Log
import com.mahshad.model.data.Object
import com.mahshad.network.ApiService
import com.mahshad.network.model.toObject
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

}