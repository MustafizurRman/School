package com.fizz.school.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

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

    @Query("SELECT * FROM school_table WHERE schoolName=:schoolName ")
    suspend fun getSchoolAndDirectors(schoolName:String):List<SchoolAndDirector>

    @Query("SELECT * FROM school_table WHERE schoolName=:schoolName ")
    suspend fun getSchoolWithStudents(schoolName: String):List<SchoolWithStudent>

    @Query("SELECT * FROM subject WHERE subjectName=:subjectName ")
    suspend fun getStudentsOfSubjects(subjectName: String):List<SubjectWithStudent>

    @Query("SELECT * FROM student WHERE studentName=:studentName ")
    suspend fun getSubjectsOfStudents(studentName: String):List<SubjectWithStudent>
}