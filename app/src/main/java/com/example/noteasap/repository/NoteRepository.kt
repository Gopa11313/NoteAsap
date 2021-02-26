package com.example.noteasap.repository

import com.example.noteasap.api.MyApiRequest
import com.example.noteasap.api.NoteApi
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.api.UserApi
import com.example.noteasap.response.NoteResponse
import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.OwnNotes
import okhttp3.MultipartBody

class NoteRepository:MyApiRequest(){
    val myApi= ServiceBuilder.buildServices(NoteApi::class.java)
    suspend fun uploadnotes(ownNotes: OwnNotes):NoteResponse{
        return apiRequest {
            myApi.uploadnote(ServiceBuilder.token!!,ownNotes)
        }
    }
    suspend fun getAllNote(userId:String):NoteResponse{
        return apiRequest {
            myApi.getAllNotes(ServiceBuilder.token!!,userId)
        }
    }
    suspend fun uploadfile(id:String,file: MultipartBody.Part): NoteResponse {
        return apiRequest {
            myApi.uploadFile(ServiceBuilder.token!!,id,file)
        }
    }

}