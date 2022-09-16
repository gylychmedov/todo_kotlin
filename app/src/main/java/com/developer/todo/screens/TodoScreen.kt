package com.developer.todo.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.developer.todo.viewModel.viewModel.TodoViewModel

@Composable
fun TodoScreen() {
    val context = LocalContext.current
    val todoViewModel = TodoViewModel(context as Application)
    val todoList = todoViewModel.todoList.observeAsState()
    var text = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(10.dp)) {
            OutlinedTextField(value = text.value, onValueChange = { text.value = it }, label = {
                Text(text = "Todo ýaz...")
            },
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = text.value)


        }
    }
}