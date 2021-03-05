package com.example.noteasap.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteasap.RoomDatabase.dao.BookmarkDao
import com.example.noteasap.RoomDatabase.dao.NoteDao
import com.example.noteasap.RoomDatabase.dao.UserDao
import com.example.noteasap.ui.model.BookMarkNotes
import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.OwnNotes
import com.example.noteasap.ui.model.User

@Database(
    entities = [(User::class),(OwnNotes::class),(BookMarkNotes::class)],
    version =8,
     exportSchema = false
)abstract class NoteAsapDb :RoomDatabase(){
    abstract fun getUserDao(): UserDao
    abstract fun getNoteDao():NoteDao
    abstract fun getBookmarkDao():BookmarkDao
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