package com.developer.todo.viewModel.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.developer.todo.data.model.Todo
import com.developer.todo.viewModel.repository.TodoRepository

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    var todoList = MutableLiveData<List<Todo>>()
    val TodoRepo: TodoRepository

    init {
        TodoRepo = TodoRepository(application)
        todoList = TodoRepo.getTodoLiveData()
    }

    fun getTodo() {
        TodoRepo.getTodoList()
    }

    fun addTodo(todo: Todo) {
        TodoRepo.addTodo(todo)
    }

    fun updateTodo(todo: Todo) {
        TodoRepo.updateTodo(todo)
    }

    fun deleteTodo(todo: Todo) {
        TodoRepo.deleteTodo(todo)
    }
}