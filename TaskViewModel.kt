package com.thousif.deepseektodolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository): ViewModel() {

    val allTasks = taskRepository.allTasks

    fun insert(task: Task) = viewModelScope.launch {
        taskRepository.insert(task)
    }

    fun delete(task: Int) = viewModelScope.launch {
        taskRepository.delete(task)

    }



}