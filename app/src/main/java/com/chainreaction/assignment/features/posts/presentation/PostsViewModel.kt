package com.chainreaction.assignment.features.posts.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chainreaction.assignment.features.posts.domain.entity.Post
import com.chainreaction.assignment.features.posts.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _successFlow = MutableStateFlow<List<Post>>(listOf())
    val successFlow = _successFlow.asStateFlow()

    private val _errorFlow = MutableSharedFlow<Exception>()
    val errorFlow = _errorFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            try {
                _successFlow.value = getPostsUseCase()
            } catch (e: Exception) {
                _errorFlow.emit(e)
            }
        }
    }
}
