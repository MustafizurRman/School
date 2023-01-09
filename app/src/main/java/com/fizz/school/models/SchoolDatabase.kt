package com.fizz.school.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fizz.school.models.entities.Director
import com.fizz.school.models.entities.School
import com.fizz.school.models.entities.Student
import com.fizz.school.models.entities.Subject

@Database(
    entities = [
        School::class,
        Student::class,
        Subject::class,
        Director::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract fun schoolDao():SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getDatabase(context: Context): SchoolDatabase {
            val tempInstance= INSTANCE
            if(tempInstance!=null)return tempInstance
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}