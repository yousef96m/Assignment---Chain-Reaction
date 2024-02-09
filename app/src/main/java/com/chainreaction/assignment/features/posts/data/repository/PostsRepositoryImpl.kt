package com.chainreaction.assignment.features.posts.data.repository

import com.chainreaction.assignment.features.posts.data.datasource.LocalPostsDataSource
import com.chainreaction.assignment.features.posts.data.datasource.RemotePostsDataSource
import com.chainreaction.assignment.features.posts.data.mapper.remoteToDomain
import com.chainreaction.assignment.features.posts.data.mapper.localToDomain
import com.chainreaction.assignment.features.posts.data.mapper.remoteToLocal
import com.chainreaction.assignment.features.posts.data.model.remote.RemotePostsModel
import com.chainreaction.assignment.features.posts.domain.PostsRepository
import com.chainreaction.assignment.features.posts.domain.entity.Post
import dagger.Reusable
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@Reusable
class PostsRepositoryImpl @Inject constructor(
    private val remotePostsDataSource: RemotePostsDataSource,
    private val localPostsDataSource: LocalPostsDataSource,
) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return runCatching {
            val localPosts = localPostsDataSource.getAllItems()
            if (localPosts.isNotEmpty()) {
                coroutineScope { fetchAndSavePosts() }
                return@runCatching localPosts.localToDomain()
            }
            val posts = fetchAndSavePosts()
            return@runCatching posts.remoteToDomain()
        }.getOrThrow()
    }

    private suspend fun fetchAndSavePosts(): List<RemotePostsModel> {
        val posts = remotePostsDataSource.getPosts()
        localPostsDataSource.insertAll(posts.remoteToLocal())
        return posts
    }
}
