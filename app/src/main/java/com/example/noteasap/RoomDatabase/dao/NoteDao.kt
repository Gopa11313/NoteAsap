package com.example.noteasap.RoomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteasap.ui.model.OwnNotes
import com.example.noteasap.ui.model.User


@Dao
interface NoteDao {

    @Insert
    suspend fun RegisterNote(list: List<OwnNotes>?)

    @Query("select * from OwnNotes")
    suspend fun getAllNote(): List<OwnNotes>

    @Query ("Delete from OwnNotes")
    suspend fun droptable()

}