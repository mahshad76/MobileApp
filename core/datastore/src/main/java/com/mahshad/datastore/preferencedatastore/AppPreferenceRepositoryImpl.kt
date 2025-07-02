package com.mahshad.datastore.preferencedatastore

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppPreferenceRepositoryImpl @Inject constructor(@ApplicationContext context: Context):
AppPreferencesRepository{
    override suspend fun saveUserName() {
        TODO("Not yet implemented")
    }

    override suspend fun savePassword() {
        TODO("Not yet implemented")
    }

}