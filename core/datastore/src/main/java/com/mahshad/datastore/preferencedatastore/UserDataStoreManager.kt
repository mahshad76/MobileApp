package com.mahshad.datastore.preferencedatastore

interface UserDataStoreManager {
    suspend fun saveUserName(username: String)
    suspend fun savePassword(password: String)
}