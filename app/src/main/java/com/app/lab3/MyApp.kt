package com.app.lab3

import android.app.Application
import com.app.lab3.database.MyDataBase
import com.app.lab3.repository.StudentRepository

class MyApp : Application() {
    private val myDataBase by lazy { MyDataBase.getDataBase(this) }
    val studentRepository by lazy { StudentRepository(myDataBase.studentDao()) }
}