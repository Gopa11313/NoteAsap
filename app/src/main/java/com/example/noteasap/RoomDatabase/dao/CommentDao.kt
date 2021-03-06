package com.example.noteasap.RoomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteasap.ui.model.Comment

@Dao
interface CommentDao {

    @Query("Delete from Comment")
    suspend fun droptable()

    @Insert
    suspend fun CommentNote(list: List<Comment>?)


    @Query("select * from Comment")
    suspend fun getComment(): List<Comment>
}