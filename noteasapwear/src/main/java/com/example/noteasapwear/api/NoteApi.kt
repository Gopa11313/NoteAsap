package com.example.noteasapwear.api

import com.example.noteasap.response.NoteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface NoteApi {
    @GET("get/notes/")
    suspend fun getAllNotes(
        @Header("Authorization") token:String,
    ): Response<NoteResponse>

}