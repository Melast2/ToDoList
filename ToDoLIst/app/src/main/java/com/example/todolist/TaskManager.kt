package com.example.todolist

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class TaskManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("TaskManager", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveTask(task: Task) {
        val taskList = getTaskList().toMutableList()
        taskList.add(task)
        saveTaskList(taskList)
    }

    fun getTaskList(): List<Task> {
        val json = sharedPreferences.getString("taskList", "")
        if (json.isNullOrEmpty()) {
            return emptyList() // Возвращаем пустой список, если JSON-строка пуста или null
        }
        return gson.fromJson(json, Array<Task>::class.java).toList()
    }

    private fun saveTaskList(taskList: List<Task>) {
        val json = gson.toJson(taskList)
        sharedPreferences.edit().putString("taskList", json).apply()
    }
}