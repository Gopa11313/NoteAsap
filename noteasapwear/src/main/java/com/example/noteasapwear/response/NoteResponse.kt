package com.example.noteasap.response

import com.example.noteasap.ui.model.Notes

data class NoteResponse(
    val success:Boolean?=null,
    val msg:String?=null,
    val data:Array<Notes>?=null,
    val id:String?=null
)