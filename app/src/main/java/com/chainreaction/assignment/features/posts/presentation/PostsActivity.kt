package com.chainreaction.assignment.features.posts.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.chainreaction.assignment.R
import com.chainreaction.assignment.core.utils.collectAsync
import com.chainreaction.assignment.databinding.ActivityMainBinding
import com.chainreaction.assignment.features.posts.domain.entity.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: PostsViewModel by viewModels()
    private val adapter = PostsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        initObservables()
    }

    private fun initRecyclerView() {
        binding.recyclerViewPosts.adapter = adapter
    }

    private fun initObservables() {
        viewModel.successFlow.collectAsync(this, ::handleSuccess)
        viewModel.errorFlow.collectAsync(this, ::handleError)
    }

    private fun handleSuccess(posts: List<Post>) {
        adapter.submitList(posts)
    }

    private fun handleError(exception: Exception) {
        // TODO:
    }
}