package com.chainreaction.assignment.core.di

import android.content.Context
import androidx.room.Room
import com.chainreaction.assignment.core.db.AppDatabase
import com.chainreaction.assignment.features.posts.data.datasource.LocalPostsDataSource
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomLocalDataModule {

    @Provides
    @Reusable
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app_database"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Reusable
    fun provideItemDao(appDatabase: AppDatabase): LocalPostsDataSource {
        return appDatabase.localPostsDataSource()
    }
}
