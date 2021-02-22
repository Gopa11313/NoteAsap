package com.example.noteasap.repository

import com.example.noteasap.api.MyApiRequest
import com.example.noteasap.api.NoteApi
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.api.UserApi
import com.example.noteasap.response.NoteResponse
import com.example.noteasap.ui.model.OwnNotes

class NoteRepository:MyApiRequest(){
    val myApi= ServiceBuilder.buildServices(NoteApi::class.java)
    suspend fun uploadnotes(ownNotes: OwnNotes):NoteResponse{
        return apiRequest {
            myApi.uploadnote(ServiceBuilder.token!!,ownNotes)
        }
    }

}