package com.mahshad.datastore.preferencedatastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(@ApplicationContext context: Context) {
    val dataStore = preferencesDataStore(name = "app_settings")


}