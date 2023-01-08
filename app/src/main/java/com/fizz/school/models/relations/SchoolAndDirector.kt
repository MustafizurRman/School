package com.fizz.school.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.fizz.school.models.entities.Director
import com.fizz.school.models.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(parentColumn = "schoolName", entityColumn = "schoolName")
    val director: Director
)