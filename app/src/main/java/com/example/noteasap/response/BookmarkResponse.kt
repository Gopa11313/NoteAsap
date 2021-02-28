package com.example.noteasap.response

import com.example.noteasap.ui.model.Bookmark

data class BookmarkResponse (
    val success:Boolean?=null,
    val msg:String?=null,
    val data:List<Bookmark>?=null,
    val id:String?=null){

}