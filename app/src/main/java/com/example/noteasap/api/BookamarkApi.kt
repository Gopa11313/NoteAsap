package com.example.noteasap.api

import com.example.noteasap.response.BookmarkResponse
import com.example.noteasap.response.NoteResponse
import com.example.noteasap.ui.model.Bookmark
import retrofit2.Response
import retrofit2.http.*

interface BookamarkApi {
    @GET("bookmark/notes/{id}")
    suspend fun getAllNotes(
        @Header("Authorization") token:String,
        @Path("id") userId:String,
    ): Response<BookmarkResponse>

@POST("note/bookmark")
suspend fun bookmarkTheNote(
    @Header("Authorization") token:String,
    @Body bookmark:Bookmark
):Response<BookmarkResponse>

    @GET("bookmark/notes/by/note/user/{id}")
    suspend fun getParticularNote(
        @Header("Authorization") token:String,
        @Path("id") userId:String,
        @Field ("noteId") noteId:String
    ):Response<BookmarkResponse>
}