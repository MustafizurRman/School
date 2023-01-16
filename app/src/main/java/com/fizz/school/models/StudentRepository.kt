package com.fizz.school.models

import androidx.lifecycle.LiveData
import com.fizz.school.models.entities.Student
import com.fizz.school.models.entities.Subject

class SchoolRepository(private val studentDao: StudentDao) {
    val readAllStudent: LiveData<List<Student>> = studentDao.readAllStudent()
    val readAllSubject:LiveData<List<Subject>> = studentDao.readAllSubject()


    suspend fun addStudent(student: Student) {
        studentDao.insertStudent(student)
    }
    suspend fun addSubject(subject: Subject) {
        studentDao.insertSubject(subject)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun updateSubject(subject: Subject) {
        studentDao.updateSubject(subject)
    }

    suspend fun deleteStudent(student: Student) {
        studentDao.deleteStudent(student)
    }

    suspend fun deleteSubject(subject: Subject) {
        studentDao.deleteSubject(subject)
    }

}
