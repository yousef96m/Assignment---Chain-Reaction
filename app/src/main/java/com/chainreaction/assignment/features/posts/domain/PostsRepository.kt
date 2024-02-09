package com.chainreaction.assignment.features.posts.domain

import com.chainreaction.assignment.features.posts.domain.entity.Post
import javax.inject.Singleton

interface PostsRepository {

    suspend fun getPosts(): List<Post>
}
