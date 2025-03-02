package com.thousif.deepseektodolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository): ViewModel() {
    // Convert Flow to StateFlow for Compose
    val allTasks: StateFlow<List<Task>> = taskRepository.allTasks
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insert(task: Task) = viewModelScope.launch {
        taskRepository.insert(task)
    }

    fun delete(task: Task) = viewModelScope.launch {
        taskRepository.delete(task)
    }
}