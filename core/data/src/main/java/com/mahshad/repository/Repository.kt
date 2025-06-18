package com.mahshad.repository

import com.mahshad.data.Object

interface Repository {
    fun getObjects(): List<Object>
}