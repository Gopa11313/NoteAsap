package com.example.noteasap.repository



import com.example.noteasap.response.NoteResponse
import com.example.noteasap.ui.model.Notes
import com.example.noteasapwear.api.MyApiRequestForWear
import com.example.noteasapwear.api.NoteApi
import com.example.noteasapwear.api.ServiceBuilder
import okhttp3.MultipartBody

class NoteRepository:MyApiRequestForWear(){
    val myApi= ServiceBuilder.buildServices(NoteApi::class.java)
//    suspend fun uploadnotes(notes: Notes):NoteResponse{
//        return apiRequest {
//            myApi.uploadnote(ServiceBuilder.token!!,notes)
//        }
//    }
    suspend fun getAllNote(): NoteResponse {
        return apiRequest {
            myApi.getAllNotes(ServiceBuilder.token!!)
        }
    }
//    suspend fun uploadfile(id:String,file: MultipartBody.Part): NoteResponse {
//        return apiRequest {
//            myApi.uploadFile(ServiceBuilder.token!!,id,file)
//        }
//    }
//    suspend fun getAllbookmarkedNotes(id:String):ForBookmarkedNotesResponse{
//        return apiRequest {
//            myApi.getAllbookmarkedNotes(ServiceBuilder.token!!,id)
//        }
//    }
//    suspend fun RateNote(id:String,ratting:String,noofRating:String):NoteResponse{
//        return apiRequest {
//            myApi.rateNote(ServiceBuilder.token!!,id,ratting,noofRating)
//        }
//    }
//
//    suspend fun getOwnNotes(userId:String):OwnNotesResponse{
//        return apiRequest {
//            myApi.getOwnNotes(ServiceBuilder.token!!,userId)
//        }
//    }

}