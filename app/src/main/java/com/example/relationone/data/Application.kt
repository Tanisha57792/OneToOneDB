package com.example.relationone.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = student::class,
            parentColumns = ["student_id"],
            childColumns = ["student_id"]
        )
    ],
    indices = [Index(value = ["student_id"],unique = true)]
)

data class Application(
    val student_id:Int,
    @PrimaryKey val application_id:Long,
    val phone_no:Int


)
