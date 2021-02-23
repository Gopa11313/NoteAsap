package com.example.noteasap.api

import com.example.noteasap.response.NoteResponse
import com.example.noteasap.ui.model.OwnNotes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NoteApi {
    @POST("upload/note")
    suspend fun uploadnote(@Header("Authorization") token:String, @Body ownnotes:OwnNotes):Response<NoteResponse>

    @GET("get/notes/{userId}")
    suspend fun getAllNotes(
        @Header("Authorization") token:String
    ):Response<NoteResponse>
}