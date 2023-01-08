package com.fizz.school.models

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fizz.school.models.entities.*
import com.fizz.school.models.relations.SchoolAndDirector
import com.fizz.school.models.relations.SchoolWithStudent
import com.fizz.school.models.relations.SubjectWithStudent

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Query("Select*From school_table")
    fun readAllSchool(): LiveData<List<School>>

    @Query("Select*From director_table")
    fun readAllDirector(): LiveData<List<Director>>

    @Query("Select*From student")
    fun readAllStudent(): LiveData<List<Student>>

    @Query("Select*From subject")
    fun readAllSubject(): LiveData<List<Subject>>

    @Query("SELECT * FROM school_table WHERE schoolName=:schoolName ")
    suspend fun getSchoolAndDirectors(schoolName:String):List<SchoolAndDirector>

    @Query("SELECT * FROM school_table WHERE schoolName=:schoolName ")
    suspend fun getSchoolWithStudents(schoolName: String):List<SchoolWithStudent>

    @Query("SELECT * FROM subject WHERE subjectName=:subjectName ")
    suspend fun getStudentsOfSubjects(subjectName: String):List<SubjectWithStudent>

    @Query("SELECT * FROM student WHERE studentName=:studentName ")
    suspend fun getSubjectsOfStudents(studentName: String):List<SubjectWithStudent>

    @Update
    suspend fun updateStudent(student: Student)

    @Update
    suspend fun updateSchool(school: School)

    @Update
    suspend fun updateSubject(subject: Subject)

    @Update
    suspend fun updateDirector(director: Director)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Delete
    suspend fun deleteSchool(school: School)

    @Delete
    suspend fun deleteSubject(subject: Subject)

    @Delete
    suspend fun deleteDirector(director: Director)
}