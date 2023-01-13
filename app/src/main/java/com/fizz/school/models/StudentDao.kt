package com.fizz.school.models

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fizz.school.models.entities.*

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudent(student: Student)

    @Query("Select * From student")
    fun readAllStudent(): LiveData<List<Student>>

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)
}