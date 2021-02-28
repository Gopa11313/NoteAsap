package com.example.noteasap.ui.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Bookmark(
        @PrimaryKey (autoGenerate = false) val _id:String="",
        val userId:String?=null,
        val noteId:String?=null
        )