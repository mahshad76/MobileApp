package com.mahshad.datastore.preferencedatastore

interface PreferenceDataStoreManager {
    suspend fun saveUserName(username: String)
    suspend fun savePassword(password: String)
}