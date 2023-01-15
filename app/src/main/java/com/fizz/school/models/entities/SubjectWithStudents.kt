package com.fizz.school.models.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectCode",
        entityColumn = "studentId",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Student>
)