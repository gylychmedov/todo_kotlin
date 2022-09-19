package com.developer.todo.screens

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.developer.todo.data.model.Todo
import com.developer.todo.ui.components.todo.TodoItem
import com.developer.todo.viewModel.factory.TodoViewModelFactory
import com.developer.todo.viewModel.viewModel.TodoViewModel

@Composable
fun TodoScreen() {
    val context = LocalContext.current
    val todoViewModel: TodoViewModel = viewModel(
        factory = TodoViewModelFactory(context.applicationContext as Application)
    )
    val todoList = todoViewModel.todoList.observeAsState(listOf())
    var text = remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        todoViewModel.getTodo()
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            Column(modifier = Modifier.padding(10.dp)) {
                OutlinedTextField(value = text.value, onValueChange = { text.value = it }, label = {
                    Text(text = "Todo...")
                },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedButton(onClick = {
                    if(text.value.length == 0) {
                        Toast.makeText(context, "Enter todo", Toast.LENGTH_SHORT).show()
                    } else {
                        todoViewModel.addTodo(Todo(0, text.value, false))
                        text.value = ""
                    }
                }) {
                    Text(text = "Add")
                }
            }

            if (todoList.value.isNotEmpty()) {
                LazyColumn() {
                    items(todoList.value.reversed()) {
                        TodoItem(todo = it, todoViewModel)
                    }
                }
            }
        }
    }
}