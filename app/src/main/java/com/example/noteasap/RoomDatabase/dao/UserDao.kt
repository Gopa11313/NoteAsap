package com.example.noteasap.RoomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteasap.RoomDatabase.entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun AddUSer(user:User)

    @Query("select * from User where email=(:email) and password=(:password)")
    suspend fun checkUSer(email:String,password:String):User
}