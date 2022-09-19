package com.developer.todo.ui.components.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.developer.todo.data.model.Todo
import com.developer.todo.viewModel.viewModel.TodoViewModel
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Trash

@Composable
fun TodoItem(todo: Todo, todoViewModel: TodoViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = todo.completed, onCheckedChange = {
                todoViewModel.updateTodo(Todo(todo.id, todo.todo, it))
            })
            Text(text = todo.todo)
        }
        IconButton(onClick = {
            todoViewModel.deleteTodo(todo)
        }) {
            Icon(imageVector = EvaIcons.Outline.Trash, contentDescription = "")
        }
    }
}