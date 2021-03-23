package com.example.noteasap.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteasap.RoomDatabase.dao.*
import com.example.noteasap.ui.model.*

@Database(
    entities = [(User::class),(Notes::class),(BookMarkNotes::class),(Comment::class),(OwnNotes::class)],
    version =13,
     exportSchema = false
)abstract class NoteAsapDb :RoomDatabase(){
    abstract fun getUserDao(): UserDao
    abstract fun getNoteDao():NoteDao
    abstract fun getBookmarkDao():BookmarkDao
    abstract fun getCommentDao():CommentDao
    abstract fun getOwnNotes():OwnnotesDao
    companion object{
        @Volatile
        private var instance: NoteAsapDb?=null
        fun getInstance(context: Context): NoteAsapDb {
            if(instance ==null){
                synchronized(NoteAsapDb::class){
                    instance = builderDatabase(context)
                }
            }
            return instance!!
        }
        private fun builderDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                NoteAsapDb::class.java,
                "NoteAsapDatabse"
            ).build()
    }
}