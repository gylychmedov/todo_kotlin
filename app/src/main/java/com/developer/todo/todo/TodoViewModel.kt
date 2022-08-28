package com.developer.todo.todo

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    var TodoList = MutableLiveData<List<TodoData>>()

    init {
        TodoList = MutableLiveData<List<TodoData>>()
    }

    fun add(todo: TodoData) {
        var temp = TodoList.value!!.toMutableList()
        temp.add(todo)
        TodoList.value = temp
    }
}