package id.gits.taskmanager.data

import id.gits.taskmanager.TaskApp
import id.gits.taskmanager.data.table.Task

/**
 * @author radhikayusuf.
 */
class TaskDatabaseHelper {


    companion object {

        private val mDatabase: TaskDatabase = TaskDatabase.getAppDatabase(TaskApp.getContextInstace())


        fun addTask(task: Task) {
            mDatabase.taskDao().insertAll(task)
        }

        fun getTask(): List<Task> {
            return mDatabase.taskDao().getAll()
        }

        fun populateWithTestData() {
            val task = Task()
            task.title = "Kotlin"
            task.description = "Awesome description"
            addTask(task)
        }
    }

}