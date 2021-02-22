package com.example.noteasap.api

import com.example.noteasap.response.NoteResponse
import com.example.noteasap.ui.model.OwnNotes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NoteApi {
    @POST("upload/note")
    suspend fun uploadnote(@Body ownnotes:OwnNotes):Response<NoteResponse>
}