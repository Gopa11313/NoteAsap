package com.example.noteasap.RoomDatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteasap.RoomDatabase.dao.UserDao
import com.example.noteasap.RoomDatabase.entity.User

@Database(
    entities = [(User::class)],
    version = 1
)
abstract class Db:RoomDatabase() {
    abstract fun getUserDao():UserDao
    companion object{
        @Volatile
        private var instance:com.example.noteasap.RoomDatabase.db.Db?=null
        fun getInstance(context: Context):com.example.noteasap.RoomDatabase.db.Db{
            if(instance==null){
                synchronized(Db::class){
                    instance=builderDatabase(context)
                }
            }
            return instance!!
        }

        private fun builderDatabase(context: Context)=Room.databaseBuilder(
            context.applicationContext,
            Db::class.java,
            "UserDatabse"
        ).build()
    }
}
