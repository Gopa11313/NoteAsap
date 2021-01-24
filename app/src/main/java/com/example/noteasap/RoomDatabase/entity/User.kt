package com.example.noteasap.RoomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User (
    val name:String?=null,
    val email:String?=null,
    val password:String?=null
){
    @PrimaryKey(autoGenerate = true)
    var UserID:Int=0
}