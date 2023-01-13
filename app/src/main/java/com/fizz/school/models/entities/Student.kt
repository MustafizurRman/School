package com.fizz.school.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentId:Int,
    val studentName:String,
    val semester:Int,
    val schoolName:String,
    val subjectName:String,
    val studentImage:String
)
