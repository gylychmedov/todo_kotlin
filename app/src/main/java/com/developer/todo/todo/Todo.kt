package com.developer.todo.todo


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoList() {
    val TodoViewModel: TodoViewModel = viewModel()
    var text = remember { mutableStateOf("") }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(value = text.value, onValueChange = { text.value = it }, label = {
                Text(
                    text = "Todo"
                )
            })
//            OutlinedButton(onClick = {
//                if{TodoViewModel.TodoList.value.isNotEmpty()} {
//                    TodoViewModel.add(TodoData(TodoViewModel.TodoList.value!!.count(), text.value, false))
//                }
//            }) {
//                Text(text = "Add")
//            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TodoPreview() {
    TodoList()
}