package com.example.noteasap.repository

import com.example.noteasap.api.BookamarkApi
import com.example.noteasap.api.CommentApi
import com.example.noteasap.api.MyApiRequest
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.response.BookmarkResponse
import com.example.noteasap.response.CommentResponse
import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.Comment
import retrofit2.Response

class CommentRepository: MyApiRequest(){
    val myApi= ServiceBuilder.buildServices(CommentApi::class.java)

    suspend fun commentNote(comment: Comment):CommentResponse{
        return apiRequest {
            myApi.comment(ServiceBuilder.token!!,comment)
        }
    }

    suspend fun getComment(noteId:String):CommentResponse{
        return apiRequest {
            myApi.getComment(ServiceBuilder.token!!,noteId)
        }
    }

}