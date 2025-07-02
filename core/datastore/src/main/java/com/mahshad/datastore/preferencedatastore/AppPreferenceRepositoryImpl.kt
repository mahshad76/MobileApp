package com.mahshad.datastore.preferencedatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppPreferenceRepositoryImpl @Inject constructor(
    @ApplicationContext private val context:
    Context
) : AppPreferencesRepository {

    private val Context.dataStore: DataStore<Preferences> by
    preferencesDataStore(name = "user_preferences")

    object PreferencesKeys {
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_PASSWORD = stringPreferencesKey("user_password")
    }

    override suspend fun saveUserName(username: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.USER_NAME] = username
        }

        val userName: Flow<String?> = context.dataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.USER_NAME]
            }
    }

    override suspend fun savePassword(password: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.USER_PASSWORD] = password
        }

        val passWord: Flow<String?> = context.dataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.USER_PASSWORD]
            }
    }

}