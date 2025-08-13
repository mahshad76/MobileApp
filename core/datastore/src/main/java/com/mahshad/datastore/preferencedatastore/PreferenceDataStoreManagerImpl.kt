package com.mahshad.datastore.preferencedatastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceDataStoreManagerImpl @Inject constructor(
    private val preferencesDataStore: DataStore<Preferences>
) : PreferenceDataStoreManager {

    private object PreferencesKeys {
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_PASSWORD = stringPreferencesKey("user_password")
    }

    override suspend fun saveUserName(username: String) {
        preferencesDataStore.edit { preferences ->
            preferences[PreferencesKeys.USER_NAME] = username
        }

        val userName: Flow<String?> =
            preferencesDataStore.data
                .map { preferences ->
                    preferences[PreferencesKeys.USER_NAME]
                }
    }

    override suspend fun savePassword(password: String) {
        preferencesDataStore.edit { preferences ->
            preferences[PreferencesKeys.USER_PASSWORD] = password
        }

        val passWord: Flow<String?> =
            preferencesDataStore.data
                .map { preferences ->
                    preferences[PreferencesKeys.USER_PASSWORD]
                }
    }
}