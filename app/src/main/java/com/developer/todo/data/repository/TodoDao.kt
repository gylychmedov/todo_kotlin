package com.developer.todo.data.repository

import androidx.room.Dao
import androidx.room.Query
import com.developer.todo.data.model.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos")
    suspend fun getAllTodo(): List<Todo>
}