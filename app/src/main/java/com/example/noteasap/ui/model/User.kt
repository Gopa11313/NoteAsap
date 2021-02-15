package com.example.noteasap.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    val name : String? = null,
    val email : String? = null,
    val password : String? = null,
    val image: String?=null
)
{
    @PrimaryKey(autoGenerate = true)
    var userId:Int=0
}