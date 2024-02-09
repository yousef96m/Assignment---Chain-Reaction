package com.chainreaction.assignment.core.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

fun <T> StateFlow<T>.collectAsync(
    lifecycleOwner: LifecycleOwner,
    collector: FlowCollector<T>
) {
    lifecycleOwner.lifecycleScope.launch {
        flowWithLifecycle(lifecycleOwner.lifecycle).distinctUntilChanged().collect(collector)
    }
}

fun <T> SharedFlow<T>.collectAsync(
    lifecycleOwner: LifecycleOwner,
    collector: FlowCollector<T>
) {
    lifecycleOwner.lifecycleScope.launch {
        flowWithLifecycle(lifecycleOwner.lifecycle).collect(
            collector
        )
    }
}