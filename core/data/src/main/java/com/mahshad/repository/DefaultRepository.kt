package com.mahshad.repository

import com.mahshad.data.Object
import javax.inject.Inject

///injection of the network module
class DefaultRepository @Inject constructor() : Repository {
    override fun getObjects(): List<Object> {
        TODO("Not yet implemented")
    }
}