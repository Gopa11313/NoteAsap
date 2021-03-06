package com.example.noteasap.ui.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Comment(
    @PrimaryKey(autoGenerate = true) val primaryKey:Int=0,
    val _id:String?=null,
    val userId:String?=null,
    val noteId:String?=null,
    val comment:String?=null
)