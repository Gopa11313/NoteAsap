package com.example.noteasap.ui.model

import com.google.gson.annotations.SerializedName

data class Signup(
    val _id : String? = null,
    val name : String? = null,
    val email : String? = null,
    val password : String? = null,
    val image:String?=null,
    val role:String?=null
)