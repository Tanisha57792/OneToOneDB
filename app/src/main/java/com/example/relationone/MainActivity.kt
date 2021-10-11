package com.example.relationone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.relationone.data.Application
import com.example.relationone.data.student
import com.example.relationone.database.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val studentList:List<student> = arrayListOf(

            student(111,"Tanisha",24),
            student(112,"vanshika",26),
            student(113,"Rani",13)




        )
        val applicationList : List<Application> = arrayListOf(
            Application(111,1,333),
            Application(112,2,444),
            Application(113,3,555),
            Application(112,4,578),

        )
        val db = database(this)

        CoroutineScope(Dispatchers.Default).launch {
            db.detailDao().insertStudent(studentList)
            db.detailDao().insertApplication(applicationList)

            val data = db.detailDao().getApplicationByStudent()
            val st =db.detailDao().getById(112)
            Log.i("TAG",st.toString())
        }
    }
}