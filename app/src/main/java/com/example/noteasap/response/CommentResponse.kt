package com.example.noteasap.response

import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.Comment

data class CommentResponse (
    val success:Boolean?=null,
    val msg:String?=null,
    val data:List<Comment>?=null
)