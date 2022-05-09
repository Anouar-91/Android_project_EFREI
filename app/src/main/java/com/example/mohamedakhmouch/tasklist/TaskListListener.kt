package com.example.anouarberrouane.tasklist

interface TaskListListener {
    fun onClickDelete(task: Task)
    fun onClickEdit(task: Task)
}


