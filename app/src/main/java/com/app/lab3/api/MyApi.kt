package com.app.lab3.api

import com.app.lab3.model.Student
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {
    @GET("books.php")
    suspend fun getStudents(@Query("number") num : Int) : Response<List<Student>>
    
}