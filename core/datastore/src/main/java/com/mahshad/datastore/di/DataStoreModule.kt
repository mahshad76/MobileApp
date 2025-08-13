package com.mahshad.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.mahshad.core.datastore.UserProfile
import com.mahshad.datastore.UserProfileSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val USER_PREFERENCES = "user_preferences"

val Context.userProfileDataStore: DataStore<UserProfile> by dataStore(
    fileName = "my_data.pb",
    serializer = UserProfileSerializer
)

val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "user_preferences"
)

@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {
    @Singleton
    @Provides
    fun providePreferencesDataStore(
        @ApplicationContext appContext: Context
    ): DataStore<Preferences> = appContext.userPreferencesDataStore

    @Singleton
    @Provides
    fun provideProtoDataStore(
        @ApplicationContext appContext: Context
    ): DataStore<UserProfile> = appContext.userProfileDataStore
}