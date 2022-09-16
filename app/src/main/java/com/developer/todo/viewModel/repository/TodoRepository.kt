package com.developer.todo.viewModel.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.developer.todo.data.DatabaseTodo
import com.developer.todo.data.model.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TodoRepository(val application: Application) {
    var todoList = MutableLiveData<List<Todo>>()
    val db = DatabaseTodo.connectDb(application)!!.todoDao()

    init {
        todoList = MutableLiveData()
    }

    fun getTodoLiveData(): MutableLiveData<List<Todo>> {
        return todoList
    }

    fun getTodoList() {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            todoList.value = db.getAllTodo()
        }
    }
}