package com.chainreaction.assignment.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chainreaction.assignment.features.posts.data.datasource.LocalPostsDataSource
import com.chainreaction.assignment.features.posts.data.model.local.LocalPostModel

@Database(entities = [LocalPostModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun localPostsDataSource(): LocalPostsDataSource
}
