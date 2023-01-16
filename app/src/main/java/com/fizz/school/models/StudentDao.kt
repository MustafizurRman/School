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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubject(subject: Subject)

    @Query("Select * From Subject")
    fun readAllSubject(): LiveData<List<Subject>>

    @Update
    suspend fun updateSubject(subject: Subject)

    @Delete
    suspend fun deleteSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectCode = :subjectCode")
    suspend fun getStudentsOfSubject(subjectCode: Int): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentId = :studentId")
    suspend fun getSubjectsOfStudent(studentId: Int): List<StudentWithSubjects>
}