package com.example.relationone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.relationone.data.Application
import com.example.relationone.data.student

@Database(
    entities = [student::class,Application::class],
    version = 1,
    exportSchema = false
)
 abstract class database: RoomDatabase() {
     abstract fun detailDao():dao

    companion object{
        @Volatile private var instance:database? = null
        private val lock= Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context)  = Room.databaseBuilder(
            context.applicationContext,
            database::class.java,
            "school"
        ).build()
    }
}
