package com.app.lab3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.time.LocalDate
import java.util.Date

@Entity(
    tableName = "students"
)

data class Student(
    @field:Json(name = "title")
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @field:Json(name = "author")
    @ColumnInfo(name = "second_name")
    val secondName: String,
    @field:Json(name = "page_number")
    @ColumnInfo(name = "birth_date")
    val birthDate: Int,
//    @field:Json(name = "phoneNumber")
//    @ColumnInfo(name = "phone")
//    val phoneNumber: String,
//    @field:Json(name = "averageRating")
//    @ColumnInfo(name = "average_rating")
//    val averageRating: Double
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    var student_id: Long = 0
}
