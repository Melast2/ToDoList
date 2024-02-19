package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddEditTaskActivity : AppCompatActivity() {

    private lateinit var taskManager: TaskManager
    private lateinit var editTextTask: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_task)

        taskManager = TaskManager(this)



        editTextTask = findViewById(R.id.editTextTask)

        val buttonSaveTask: Button = findViewById(R.id.buttonSaveTask)
        buttonSaveTask.setOnClickListener {
            val taskTitle = editTextTask.text.toString()
            if (taskTitle.isNotBlank()) {
                val task = Task(0, taskTitle) // 0 для новой задачи, реальный id будет присвоен при сохранении
                taskManager.saveTask(task)
                finish()
            }
        }
    }
}