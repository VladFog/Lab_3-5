package com.app.lab3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.lab3.dao.StudentDao
import com.app.lab3.model.Student

@Database(
    entities = [Student::class],
    version = 1,
    exportSchema = false
)
abstract class MyDataBase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: MyDataBase? = null
        fun getDataBase(context: Context): MyDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    MyDataBase::class.java,
                    "my_database.db3"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}