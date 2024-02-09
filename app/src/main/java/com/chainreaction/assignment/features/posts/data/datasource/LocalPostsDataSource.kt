package com.chainreaction.assignment.features.posts.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chainreaction.assignment.features.posts.data.model.local.LocalPostModel

@Dao
interface LocalPostsDataSource {

    @Query("SELECT * FROM posts")
    fun getAllItems(): List<LocalPostModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<LocalPostModel>)
}
