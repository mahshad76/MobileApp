package com.mahshad.datastore.di

import android.content.Context
import com.mahshad.datastore.preferencedatastore.PreferenceDataStoreManager
import com.mahshad.datastore.protodatastore.UserProfileRepository
import com.mahshad.datastore.protodatastore.UserProfileRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {
    @Singleton
    @Provides
    fun providePreferenceDataStore(@ApplicationContext context: Context): PreferenceDataStoreManager =
        PreferenceDataStoreManager(context)

    @Singleton
    @Binds
    abstract fun bindUserProfileRepository(userProfileRepository: UserProfileRepository):
            UserProfileRepositoryImpl

}