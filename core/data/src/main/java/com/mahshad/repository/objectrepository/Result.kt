package com.mahshad.repository.objectrepository

sealed class Result<out T> {
    data class Successful<out T>(val data: T) : Result<T>()
    data class Error(val error: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}