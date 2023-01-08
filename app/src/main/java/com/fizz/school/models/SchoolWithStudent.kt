package com.fizz.school.models

import androidx.room.Embedded
import androidx.room.Relation


data class SchoolWithStudent(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)