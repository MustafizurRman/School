package com.fizz.school.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(
    @PrimaryKey(autoGenerate = false)
    val subjectCode:Int,
    val subjectName:String,
    val subjectDetail:String,
    val subjectInstructor:String
)
