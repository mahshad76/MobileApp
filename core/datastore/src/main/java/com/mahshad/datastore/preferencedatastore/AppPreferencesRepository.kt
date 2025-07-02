package com.mahshad.datastore.preferencedatastore

interface AppPreferencesRepository {
    suspend fun saveUserName()
    suspend fun savePassword()
}