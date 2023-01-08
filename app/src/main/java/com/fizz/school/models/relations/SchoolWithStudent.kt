package com.fizz.school.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.fizz.school.models.entities.School
import com.fizz.school.models.entities.Student


data class SchoolWithStudent(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)