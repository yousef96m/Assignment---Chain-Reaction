package com.chainreaction.assignment.core.di

import com.chainreaction.assignment.features.posts.data.repository.PostsRepositoryImpl
import com.chainreaction.assignment.features.posts.domain.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideRemoteAssignmentDataSource(postsRepository: PostsRepositoryImpl): PostsRepository
}
