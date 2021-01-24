package com.example.noteasap.RoomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.noteasap.RoomDatabase.entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun AddUSer(user:User)
}