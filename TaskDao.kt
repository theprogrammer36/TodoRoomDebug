package com.thousif.deepseektodolist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun delete(task: Int)

    @Query("SELECT * FROM tasks ORDER BY id ASC")
    fun getAllTasks(): Flow<List<Task>>

}