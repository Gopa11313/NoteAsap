package com.example.noteasap.RoomDatabase.dao

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import com.example.noteasap.ui.model.BookMarkNotes
import com.example.noteasap.ui.model.OwnNotes

@Dao
interface BookmarkDao {

    @Query("Delete from BookMarkNotes")
    suspend fun droptable()

    @Insert
    suspend fun bookmarkNote(list: List<BookMarkNotes>?)


    @Query("select * from BookMarkNotes")
    suspend fun getBookmarkNote(): List<BookMarkNotes>
}