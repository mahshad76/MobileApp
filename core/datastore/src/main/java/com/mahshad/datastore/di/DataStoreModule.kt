package com.mahshad.datastore.di

import com.mahshad.datastore.preferencedatastore.AppPreferenceRepositoryImpl
import com.mahshad.datastore.preferencedatastore.AppPreferencesRepository
import com.mahshad.datastore.protodatastore.UserProfileRepository
import com.mahshad.datastore.protodatastore.UserProfileRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {

    @Singleton
    @Binds
    abstract fun bindUserProfileRepository(userProfileRepository: UserProfileRepository):
            UserProfileRepositoryImpl

    @Singleton
    @Binds
    abstract fun bindAppPreferenceRepository(appPreferenceRepository: AppPreferencesRepository):
            AppPreferenceRepositoryImpl
}