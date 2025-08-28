package com.mahshad.di

import com.mahshad.repository.objectrepository.DefaultObjectRepository
import com.mahshad.repository.objectrepository.ObjectRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {
    @Binds
    abstract fun bindObjectRepository(defaultObjectRepository: DefaultObjectRepository):
            ObjectRepository

//    @Binds
//    abstract fun bindDataBaseRepository(defaultDataBaseRepository: DefaultDataBaseRepository):
//            DataBaseRepository
}