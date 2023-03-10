package com.fizz.school.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.fizz.school.models.entities.Student
import com.fizz.school.models.entities.Subject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application):AndroidViewModel(application) {

    val readAllStudent: LiveData<List<Student>>
    val readAllSubject: LiveData<List<Subject>>
    val repository:SchoolRepository

    init {
        val schoolDao= SchoolDatabase.getDatabase(application).studentDao()
        repository= SchoolRepository(schoolDao)
        readAllStudent=repository.readAllStudent
        readAllSubject=repository.readAllSubject
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

    fun addSubject(subject: Subject) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSubject( subject)
        }
    }

    fun updateSubject(subject: Subject) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSubject( subject)
        }
    }

    fun deleteSubject(subject: Subject) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteSubject( subject)
        }
    }

}