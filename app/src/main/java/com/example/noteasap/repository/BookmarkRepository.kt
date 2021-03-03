package com.example.noteasap.repository

import com.example.noteasap.api.BookamarkApi
import com.example.noteasap.api.MyApiRequest
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.response.BookmarkResponse
import com.example.noteasap.ui.model.Bookmark

class BookmarkRepository: MyApiRequest(){
    val myApi= ServiceBuilder.buildServices(BookamarkApi::class.java)
    suspend fun getallbookmarkedNotes(id:String): BookmarkResponse {
        return apiRequest {
            myApi.getAllNotes(ServiceBuilder.token!!,id)
        }
    }

    suspend fun BookamarkNote(bookmark: Bookmark):BookmarkResponse{
        return apiRequest {
            myApi.bookmarkTheNote(ServiceBuilder.token!!,bookmark)
        }
    }
}