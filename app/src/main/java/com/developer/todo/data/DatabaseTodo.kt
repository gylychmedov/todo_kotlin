package com.developer.todo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.developer.todo.data.model.Todo
import com.developer.todo.data.repository.TodoDao

@Database(entities = [Todo::class], version = 1)
abstract class DatabaseTodo: RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        var INSTANCE: DatabaseTodo? = null

        fun connectDb(context: Context): DatabaseTodo? {
            if (INSTANCE == null) {
                synchronized(DatabaseTodo::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseTodo::class.java,
                        "todos.sqlite"
                    ).createFromAsset("todos.sqlite").build()
                }
            }
            return INSTANCE
        }

    }
}