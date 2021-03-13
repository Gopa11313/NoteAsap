package com.example.noteasap.RoomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteasap.ui.model.OwnNotes

@Dao
interface OwnnotesDao {
    @Insert
    suspend fun RegisterNote(list: List<OwnNotes>?)

    @Query("select * from OwnNotes")
    suspend fun getAllNote(): List<OwnNotes>

    @Query("Delete from OwnNotes")
    suspend fun droptable()
}