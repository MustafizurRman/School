package com.fizz.school.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.fizz.school.models.entities.Director
import com.fizz.school.models.entities.School
import com.fizz.school.models.entities.Student
import com.fizz.school.models.entities.Subject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application):AndroidViewModel(application) {

    private val readAllSchool: LiveData<List<School>>
    private val readAllStudent: LiveData<List<Student>>
    private val readAllSubject: LiveData<List<Subject>>
    private val readAllDirector: LiveData<List<Director>>
    val repository:SchoolRepository

    init {
        val schoolDao= SchoolDatabase.getDatabase(application).schoolDao()
        repository= SchoolRepository(schoolDao)
        readAllSchool=repository.readAllSchool
        readAllDirector=repository.readAllDirector
        readAllStudent=repository.readAllStudent
        readAllSubject=repository.readAllSubject
    }

    fun addDirector(director: Director) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDirector(director)
        }
    }

    fun updateDirector(director: Director) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDirector(director)
        }
    }
    fun deleteDirector(director: Director) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteDirector(director)
        }
    }

    fun addStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStudent(student)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateStudent(student)
        }
    }
    fun deleteStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteStudent( student)
        }
    }

}