package id.gits.taskmanager

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author radhikayusuf.
 */
class TaskApp : Application(){

    override fun onCreate() {
        super.onCreate()
        APP_CONTEXT = applicationContext
    }


    companion object {
        @SuppressLint("StaticFieldLeak")
        private var APP_CONTEXT: Context? = null

        fun getContextInstace(): Context{
            return APP_CONTEXT!!
        }
    }

}