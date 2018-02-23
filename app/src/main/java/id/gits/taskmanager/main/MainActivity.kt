package id.gits.taskmanager.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.gits.taskmanager.R
import id.gits.taskmanager.data.TaskDatabaseHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val task = TaskDatabaseHelper.getTask()

        if (task.isEmpty()) {
            TaskDatabaseHelper.populateWithTestData()
            Log.wtf("LOG", "database updated by dummy data")
        } else {
            Log.wtf("LOG", "database not null")
        }
    }
}
