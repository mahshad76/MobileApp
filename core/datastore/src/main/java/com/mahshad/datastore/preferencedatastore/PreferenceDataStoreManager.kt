package com.mahshad.datastore.preferencedatastore

import kotlinx.coroutines.flow.Flow

interface PreferenceDataStoreManager {
    suspend fun saveUserName(username: String)
    suspend fun savePassword(password: String)
    fun getUsername(): Flow<String?>
    fun getPassword(): Flow<String?>
}