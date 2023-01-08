package com.fizz.school.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.fizz.school.models.entities.Student
import com.fizz.school.models.entities.StudentSubjectCrossRef
import com.fizz.school.models.entities.Subject

data class StudentWithSubject(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)
