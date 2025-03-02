package com.thousif.deepseektodolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TaskViewModelFactory(private val taskRepository: TaskRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create (modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(taskRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
