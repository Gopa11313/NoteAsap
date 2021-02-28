package com.example.noteasap.response

import com.example.noteasap.ui.model.OwnNotes

data class NoteResponse(
    val success:Boolean?=null,
    val msg:String?=null,
    val data:MutableList<OwnNotes>?=null,
    val id:String?=null
)