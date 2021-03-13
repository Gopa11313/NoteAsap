package com.example.noteasap.response

import com.example.noteasap.ui.model.BookMarkNotes

//import com.example.noteasap.ui.model.OwnNotes


data class ForBookmarkedNotesResponse (
    val success:Boolean?=null,
    val msg:String?=null,
    val data:List<BookMarkNotes>?=null,
    val id:String?=null
)