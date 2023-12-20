package com.app.lab3.model

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "api"
)

data class ApiData(
    @ColumnInfo(name = "user_id")
    val userId: Long,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "body")
    val body: String
) {
    @PrimaryKey()
    @ColumnInfo(name = "student_id")
    var student_id: Long = 0
}