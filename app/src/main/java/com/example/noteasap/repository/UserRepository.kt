package com.example.noteasap.repository

import com.example.noteasap.api.MyApiRequest
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.api.UserApi
import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.User
import okhttp3.MultipartBody

class UserRepository:MyApiRequest(){
    val myApi= ServiceBuilder.buildServices(UserApi::class.java)

    suspend fun registerUser(user: User):UserResponse{
        return apiRequest {
            myApi.registerUSer(user)
        }
    }
    suspend fun checkUSer(user: User):UserResponse{
        return apiRequest {
            myApi.checkUSer(user) }
    }
    suspend fun uploadimage(id:String,file:MultipartBody.Part):UserResponse{
        return apiRequest {
            myApi.uploadImage(ServiceBuilder.token!!,id,file)
        }
    }

    suspend fun getme(id: String):UserResponse{
        return apiRequest {
            myApi.getme(ServiceBuilder.token!!,id)
        }
    }
}

