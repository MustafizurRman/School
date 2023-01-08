package com.fizz.school.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StudentWithSubject(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)
