package com.mahshad.network

import com.mahshad.network.model.ObjectDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/objects")
    suspend fun getObjects(): Response<List<ObjectDto>?>

    @GET("/objects")
    suspend fun getObjectsById(@Query("id") ids: List<Int>): Response<List<ObjectDto>?>

    @POST("/objects")
    suspend fun postAnObject(@Body body: ObjectDto): Response<ObjectDto>

    @DELETE("/objects/{id}")
    suspend fun deleteAnObject(@Path("id") id: Int): Response<ResponseBody>

    @PATCH("/objects/{id}")
    suspend fun partialUpdate(
        @Path("id") id: Int,
        @Body body: Map<String, Any>
    ): Response<ObjectDto>

    @PUT("/objects/{id}")
    suspend fun update(@Path("id") id: Int, @Body body: ObjectDto): Response<ObjectDto>

}