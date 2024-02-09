package com.chainreaction.assignment.features.posts.domain.usecase

import com.chainreaction.assignment.features.posts.domain.PostsRepository
import com.chainreaction.assignment.features.posts.domain.entity.Post
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Singleton

@Reusable
class GetPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(): List<Post> {
        return postsRepository.getPosts()
    }
}
