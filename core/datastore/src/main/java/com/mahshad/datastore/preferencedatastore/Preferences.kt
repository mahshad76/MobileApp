package com.mahshad.datastore.preferencedatastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(@ApplicationContext private val context: Context) {
    companion object {
        private const val USER_PREFERENCES_NAME = "user_preferences"
    }

    private object PreferencesKeys {
        val SHOW_COMPLETED = stringPreferencesKey("show_completed")
    }

    private val Context.dataStore by preferencesDataStore(
        name = Companion.USER_PREFERENCES_NAME
    )

    suspend fun writeToDataStore(value: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.SHOW_COMPLETED] = value

        }
    }

    suspend fun readFromDataStore() {
    }
}