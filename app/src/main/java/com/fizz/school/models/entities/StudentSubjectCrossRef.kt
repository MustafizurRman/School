package com.fizz.school.models.entities

import androidx.room.Entity

@Entity(primaryKeys = ["studentId","subjectCode"])
data class StudentSubjectCrossRef(
    val studentId: Int,
    val subjectCode: Int
)