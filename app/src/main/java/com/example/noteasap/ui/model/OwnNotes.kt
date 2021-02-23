package com.example.noteasap.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OwnNotes(
    @PrimaryKey (autoGenerate = false) val _id:String="",
               val userId: String? =null,
               val level:String?=null,
               val subject:String?=null,
               val c_name:String?=null,
               val file:String?=null,
               val topic:String?=null,
               val description:String?=null ){

}