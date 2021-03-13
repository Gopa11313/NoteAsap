package com.example.noteasap.repository

import com.example.noteasap.api.MyApiRequest
import com.example.noteasap.api.NoteApi
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.response.ForBookmarkedNotesResponse
import com.example.noteasap.response.NoteResponse
import com.example.noteasap.response.OwnNotesResponse
import com.example.noteasap.ui.model.Notes
import okhttp3.MultipartBody

class NoteRepository:MyApiRequest(){
    val myApi= ServiceBuilder.buildServices(NoteApi::class.java)
    suspend fun uploadnotes(notes: Notes):NoteResponse{
        return apiRequest {
            myApi.uploadnote(ServiceBuilder.token!!,notes)
        }
    }
    suspend fun getAllNote():NoteResponse{
        return apiRequest {
            myApi.getAllNotes(ServiceBuilder.token!!)
        }
    }
    suspend fun uploadfile(id:String,file: MultipartBody.Part): NoteResponse {
        return apiRequest {
            myApi.uploadFile(ServiceBuilder.token!!,id,file)
        }
    }
    suspend fun getAllbookmarkedNotes(id:String):ForBookmarkedNotesResponse{
        return apiRequest {
            myApi.getAllbookmarkedNotes(ServiceBuilder.token!!,id)
        }
    }
    suspend fun RateNote(id:String,ratting:String,noofRating:String):NoteResponse{
        return apiRequest {
            myApi.rateNote(ServiceBuilder.token!!,id,ratting,noofRating)
        }
    }
    
    suspend fun getOwnNotes(userId:String):OwnNotesResponse{
        return apiRequest {
            myApi.getOwnNotes(ServiceBuilder.token!!,userId)
        }
    }

}