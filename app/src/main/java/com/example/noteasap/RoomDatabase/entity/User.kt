package com.example.noteasap.RoomDatabase.entity

import androidx.room.Entity

@Entity
class User (
    val name:String?=null,
    val email:String?=null,
    val password:String?=null
)