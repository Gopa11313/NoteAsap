package com.example.noteasap.ui.model

import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey (autoGenerate = false) val _id:String="",
    val name : String? = null,
    val email : String? = null,
    val password : String? = null,
    val image: String?=null
)