package com.developer.todo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    val id: Int,

    @NotNull
    @ColumnInfo(name = "todo")
    val todo: String,

    @NotNull
    @ColumnInfo(name = "completed")
    val completed: Boolean
)
