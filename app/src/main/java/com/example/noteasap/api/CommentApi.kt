package com.example.noteasap.api

import com.example.noteasap.response.CommentResponse
import com.example.noteasap.ui.model.Comment
import retrofit2.Response
import retrofit2.http.*

interface CommentApi {
    @POST("comment/on/note")
    suspend fun comment(
        @Header("Authorization") token:String,
        @Body comment: Comment
    ):Response<CommentResponse>

    @GET("get/comment/{noteId}")
    suspend fun getComment(
        @Header("Authorization") token:String,
        @Path("noteId") userId:String
    ):Response<CommentResponse>
}