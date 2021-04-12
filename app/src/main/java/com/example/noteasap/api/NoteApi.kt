package com.example.noteasap.api

import com.example.noteasap.response.ForBookmarkedNotesResponse
import com.example.noteasap.response.NoteResponse
import com.example.noteasap.response.OwnNotesResponse
import com.example.noteasap.ui.model.Notes
import com.example.noteasap.ui.model.OwnNotes
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface NoteApi {
    @POST("upload/note")
    suspend fun uploadnote(@Header("Authorization") token:String, @Body ownnotes:Notes):Response<NoteResponse>

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

    @PUT("rate/the/note/{id}/{ratting}/{noofRating}")
    suspend fun rateNote(
        @Header("Authorization") token:String,
        @Path("id") userId:String,
        @Path("ratting") ratting:String,
        @Path("noofRating") noofRating: String,
    ):Response<NoteResponse>

    @GET("get/Ownnotes/{userId}")
    suspend fun getOwnNotes(
        @Header("Authorization") token:String,
        @Path("userId") userId:String,
    ):Response<OwnNotesResponse>

    @DELETE("/delete/note/{Nid}")
    suspend fun deleteNote(
        @Header("Authorization") token:String,
        @Path("Nid") Nid:String,
    ):Response<OwnNotesResponse>

    @PUT ("Update/note/and")
    suspend fun updateNote(
        @Header("Authorization") token:String,
        @Body ownNotes: OwnNotes
    ):Response<OwnNotesResponse>
}