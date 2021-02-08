package com.example.noteasap.repository

import com.example.noteasap.api.MyApiRequest
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.api.UserApi
import com.example.noteasap.response.SignupResponse
import com.example.noteasap.ui.model.User

class UserRepository:MyApiRequest(){
    val myApi= ServiceBuilder.buildServices(UserApi::class.java)

    suspend fun registerUSer(user: User):SignupResponse{
        return apiRequest {
            myApi.registerUser(user)
        }
    }
    suspend fun checkUSer(username:String,password:String):SignupResponse{
        return apiRequest {
            myApi.checkUSer(username,password) }
    }
}