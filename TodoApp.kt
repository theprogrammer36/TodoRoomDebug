package com.thousif.deepseektodolist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun TodoApp(viewModel: TaskViewModel){

    // State for the new task input
    var newTaskTitle by remember { mutableStateOf("") }

    // Observe tasks from the ViewModel
    val tasks by viewModel.allTasks.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = newTaskTitle,
                onValueChange = {newTaskTitle = it},
                label = {Text("Add Task")},
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                if (newTaskTitle.isNotBlank()){
                    viewModel.insert(Task(title = newTaskTitle))
                    newTaskTitle = ""
                }
            }) {
                Text("Add")

            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(tasks) {task ->
                TaskItem(
                    task = task,
                    onDelete = { viewModel.delete(task)}
                )
            }
        }


    }






}

