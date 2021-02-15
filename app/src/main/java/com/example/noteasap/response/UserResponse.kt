package com.example.noteasap.response

import com.example.noteasap.ui.model.User

data class UserResponse (
    val success:Boolean?=null,
    val token:String?=null,
    val msg:String?=null,
    val data:List<User>?=null
)