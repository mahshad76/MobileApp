package com.mahshad.database.di

import android.content.Context
import androidx.room.Room
import com.mahshad.database.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {
    @Provides
    @Singleton
    fun providesObjectDatabase(
        @ApplicationContext context: Context,
    ): Database = Room.databaseBuilder(
        context,
        Database::class.java,
        Database.DATABASE_NAME,
    ).build()
}