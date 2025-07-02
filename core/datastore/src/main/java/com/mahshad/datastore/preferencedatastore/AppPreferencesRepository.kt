package com.mahshad.datastore.preferencedatastore

interface AppPreferencesRepository {
    suspend fun saveUserName(username: String)
    suspend fun savePassword(password: String)
}