package com.thousif.deepseektodolist

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) = try {
        taskDao.insertTask(task)
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun delete(task: Task) = try {
        taskDao.delete(task)
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }


}