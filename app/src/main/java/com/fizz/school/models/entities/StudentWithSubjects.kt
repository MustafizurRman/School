package com.fizz.school.models.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "subjectCode",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)