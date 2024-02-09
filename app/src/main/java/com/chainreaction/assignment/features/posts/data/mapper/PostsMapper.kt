package com.chainreaction.assignment.features.posts.data.mapper

import com.chainreaction.assignment.features.posts.data.model.local.LocalPostModel
import com.chainreaction.assignment.features.posts.data.model.remote.RemotePostsModel
import com.chainreaction.assignment.features.posts.domain.entity.Post

fun List<RemotePostsModel>.remoteToLocal(): List<LocalPostModel> {
    return map {
        LocalPostModel(
            id = it.id,
            title = it.title,
            body = it.body,
        )
    }
}

fun List<RemotePostsModel>.remoteToDomain(): List<Post> {
    return map {
        Post(
            id = it.id,
            title = it.title,
            body = it.body,
        )
    }
}

fun List<LocalPostModel>.localToDomain(): List<Post> {
    return map {
        Post(
            id = it.id,
            title = it.title,
            body = it.body,
        )
    }
}
