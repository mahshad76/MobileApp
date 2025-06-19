package com.mahshad.network.di

import com.mahshad.network.retrofit.NetworkDataSource
import com.mahshad.network.retrofit.RetrofitNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class NetworkDataModule {
    @Singleton
    @Binds
    abstract fun bindNetworkDataSource(retrofitNetwork: RetrofitNetwork): NetworkDataSource
}