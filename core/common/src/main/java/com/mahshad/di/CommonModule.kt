package com.mahshad.di

import com.mahshad.common.DefaultStringResolver
import com.mahshad.common.StringResolver
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class CommonModule {
    @Singleton
    @Binds
    abstract fun bindStringResolver(defaultStringResolver: DefaultStringResolver): StringResolver

}