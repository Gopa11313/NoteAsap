package com.example.noteasap.RoomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteasap.ui.model.Notes


@Dao
interface NoteDao {

    @Insert
    suspend fun RegisterNote(list: List<Notes>?)

    @Query("select * from Notes")
    suspend fun getAllNote(): List<Notes>

    @Query ("Delete from Notes")
    suspend fun droptable()

}