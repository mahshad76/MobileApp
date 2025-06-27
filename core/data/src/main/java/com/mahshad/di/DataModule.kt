package com.mahshad.di

import com.mahshad.repository.DefaultObjectRepository
import com.mahshad.repository.ObjectRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {
    @Binds
    abstract fun bindObjectRepository(defaultObjectRepository: DefaultObjectRepository): ObjectRepository
}