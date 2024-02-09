package com.chainreaction.assignment.features.posts.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class LocalPostModel(
    @PrimaryKey
    val id: Int,

    val title: String,

    val body: String,
)
