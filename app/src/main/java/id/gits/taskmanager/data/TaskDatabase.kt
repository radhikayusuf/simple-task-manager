package id.gits.taskmanager.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import id.gits.taskmanager.data.table.TaskDao
import android.arch.persistence.room.Room
import android.content.Context
import id.gits.taskmanager.data.table.Task


/**
 * @author radhikayusuf.
 */

@Database(entities = arrayOf(Task::class), version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {

        private var INSTANCE: TaskDatabase? = null

        fun getAppDatabase(context: Context): TaskDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, TaskDatabase::class.java, "user-database")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}
