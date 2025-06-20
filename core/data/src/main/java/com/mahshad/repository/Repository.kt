package com.mahshad.repository

import com.mahshad.model.data.Object

interface Repository {
    suspend fun getObjects(): List<Object>?
}

