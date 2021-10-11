package com.example.relationone.data

import androidx.room.Embedded
import androidx.room.Relation

data class Student_Data(
    @Embedded
    val student: student,


    @Relation(
        parentColumn = "student_id",
        entityColumn = "student_id"

    )
    val application: Application

)
