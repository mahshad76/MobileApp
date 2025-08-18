package com.mahshad.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.mahshad.core.datastore.UserProfile
import com.mahshad.datastore.UserProfileSerializer
import com.mahshad.datastore.preferencedatastore.PreferenceDataStoreManager
import com.mahshad.datastore.preferencedatastore.PreferenceDataStoreManagerImpl
import com.mahshad.datastore.protodatastore.ProtoDataStoreManager
import com.mahshad.datastore.protodatastore.ProtoDataStoreManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.userProfileDataStore: DataStore<UserProfile> by dataStore(
    fileName = "my_data.pb",
    serializer = UserProfileSerializer
)

val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "user_preferences"
)

@InstallIn(SingletonComponent::class)
@Module
abstract class DataStoreModule {
    companion object {
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

    @Singleton
    @Binds
    abstract fun bindPreferenceDataStoreManager(
        preferenceDataStoreManagerImpl:
        PreferenceDataStoreManagerImpl
    ):
            PreferenceDataStoreManager

    @Singleton
    @Binds
    abstract fun bindProtoDataStoreManager(
        protoDataStoreManagerImpl:
        ProtoDataStoreManagerImpl
    ):
            ProtoDataStoreManager
}