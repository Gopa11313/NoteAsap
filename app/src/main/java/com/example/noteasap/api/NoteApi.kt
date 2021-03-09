package com.example.noteasap.api

import com.example.noteasap.response.ForBookmarkedNotesResponse
import com.example.noteasap.response.NoteResponse
import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.OwnNotes
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface NoteApi {
    @POST("upload/note")
    suspend fun uploadnote(@Header("Authorization") token:String, @Body ownnotes:OwnNotes):Response<NoteResponse>

    @GET("get/notes/")
    suspend fun getAllNotes(
        @Header("Authorization") token:String,
    ):Response<NoteResponse>

    @Multipart
    @PUT("upload/user/file/{id}")
    suspend fun uploadFile(
        @Header("Authorization") token:String,
        @Path("id") id:String,
        @Part file: MultipartBody.Part
    ): Response<NoteResponse>

    @GET("note/by/notid/{id}")
    suspend fun getAllbookmarkedNotes(
        @Header("Authorization") token:String,
        @Path("id") userId:String,
    ):Response<ForBookmarkedNotesResponse>

    @PUT("rate/note/")
    suspend fun rateNote(
        @Header("Authorization") token:String,
        @Body ownnotes: OwnNotes
    ):Response<NoteResponse>
}