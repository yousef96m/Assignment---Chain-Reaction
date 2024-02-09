package com.chainreaction.assignment.features.posts.data.datasource

import com.chainreaction.assignment.features.posts.data.model.remote.RemotePostsModel
import retrofit2.http.GET


interface RemotePostsDataSource {

    @GET("posts")
    suspend fun getPosts(): List<RemotePostsModel>

}
