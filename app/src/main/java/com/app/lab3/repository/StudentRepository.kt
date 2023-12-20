package com.app.lab3.repository

import com.app.lab3.api.MyApi
import com.app.lab3.api.RetrofitClient
import com.app.lab3.dao.StudentDao
import com.app.lab3.model.Student

class StudentRepository(private val studentDao: StudentDao) {
    private val retrofitClient = RetrofitClient.getClient()
    private val myApi = retrofitClient.create(MyApi::class.java)
    suspend fun loadStudents(num : Int): List<Student>? {
        val response = myApi.getStudents(num)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    suspend fun clearStudents() {
        studentDao.deleteAllStudents()
    }

    suspend fun insertStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    suspend fun insertStudents(students: List<Student>) {
        studentDao.insertStudents(students)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        studentDao.deleteStudent(student)
    }

    suspend fun getAllStudents(): List<Student> {
        return studentDao.getAllStudents()
    }

}