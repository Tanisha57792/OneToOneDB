package com.example.relationone.database

import androidx.room.*
import com.example.relationone.data.Application
import com.example.relationone.data.Student_Data
import com.example.relationone.data.student


@Dao
interface dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(st:List<student>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApplication(ap:List<Application>)

    @Query("SELECT * FROM student")
    fun getApplicationByStudent():Student_Data

    @Query("SELECT * FROM student WHERE student_id= :student_id")
    @Transaction
    fun getById(student_id:Int):List<Student_Data>
}