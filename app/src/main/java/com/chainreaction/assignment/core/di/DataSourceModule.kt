package com.chainreaction.assignment.core.di

import com.chainreaction.assignment.features.posts.data.datasource.RemotePostsDataSource
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Reusable
    fun provideRemoteAssignmentDataSource(retrofit: Retrofit): RemotePostsDataSource {
        return retrofit.create(RemotePostsDataSource::class.java)
    }
}
