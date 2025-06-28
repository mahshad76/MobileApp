package com.mahshad.datastore.preferencedatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object PreferencesKeys {
    val USER_NAME = stringPreferencesKey("user_name")
}

class PreferenceDataStoreManager
    (private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by
    preferencesDataStore(name = "user_preferences")

    suspend fun saveUserName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.USER_NAME] = name
        }

        val userName: Flow<String?> = context.dataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.USER_NAME]
            }
    }
}