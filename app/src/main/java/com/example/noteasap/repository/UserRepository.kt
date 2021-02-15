package com.example.noteasap.repository

import com.example.noteasap.api.MyApiRequest
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.api.UserApi
import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.User

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
}

