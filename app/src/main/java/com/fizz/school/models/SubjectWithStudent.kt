package com.fizz.school.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SubjectWithStudent (
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
        )