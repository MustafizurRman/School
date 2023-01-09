package com.fizz.school.models

import androidx.lifecycle.LiveData
import com.fizz.school.models.entities.Director
import com.fizz.school.models.entities.School
import com.fizz.school.models.entities.Student
import com.fizz.school.models.entities.Subject

class SchoolRepository(private val schoolDao: SchoolDao) {
    val readAllSchool: LiveData<List<School>> = schoolDao.readAllSchool()
    val readAllDirector: LiveData<List<Director>> = schoolDao.readAllDirector()
    val readAllStudent: LiveData<List<Student>> = schoolDao.readAllStudent()
    val readAllSubject:LiveData<List<Subject>> = schoolDao.readAllSubject()

    suspend fun addSchool(school: School) {
        schoolDao.insertSchool(school)
    }

    suspend fun addDirector(director: Director) {
        schoolDao.insertDirector(director)
    }

    suspend fun addStudent(student: Student) {
        schoolDao.insertStudent(student)
    }

    suspend fun addSubject(subject: Subject) {
        schoolDao.insertSubject(subject)
    }

    suspend fun updateSchool(school: School) {
        schoolDao.updateSchool(school)
    }

    suspend fun updateStudent(student: Student) {
        schoolDao.updateStudent(student)
    }

    suspend fun updateSubject(subject: Subject) {
        schoolDao.updateSubject(subject)
    }

    suspend fun updateDirector(director: Director) {
        schoolDao.updateDirector(director)
    }

    suspend fun deleteStudent(student: Student) {
        schoolDao.deleteStudent(student)
    }

    suspend fun deleteSubject(subject: Subject) {
        schoolDao.deleteSubject(subject)
    }
    suspend fun deleteSchool(school: School) {
        schoolDao.deleteSchool(school)
    }
    suspend fun deleteDirector(director: Director){
        schoolDao.deleteDirector(director)
    }
}
