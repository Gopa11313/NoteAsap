package com.example.noteasap.api

import com.example.noteasap.response.NoteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface Bookamark {
    @GET("bookmark/notes/{id}")
    suspend fun getAllNotes(
        @Header("Authorization") token:String,
        @Path("id") userId:String,
    ): Response<NoteResponse>
}