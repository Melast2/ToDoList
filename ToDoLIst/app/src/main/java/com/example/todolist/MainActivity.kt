package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView


class MainActivity : AppCompatActivity() {

    private lateinit var taskManager: TaskManager
    private lateinit var listViewTasks: ListView
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskManager = TaskManager(this)
        listViewTasks = findViewById(R.id.listViewTasks)

        val tasks = taskManager.getTaskList()
        adapter = TaskAdapter(this, tasks)
        listViewTasks.adapter = adapter

        val buttonAddTask: Button = findViewById(R.id.buttonAddTask)
        buttonAddTask.setOnClickListener {
            val intent = Intent(this, AddEditTaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val tasks = taskManager.getTaskList()
        adapter = TaskAdapter(this, tasks)
        listViewTasks.adapter = adapter
    }
}