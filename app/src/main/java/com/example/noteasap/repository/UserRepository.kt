package com.example.noteasap.repository

import com.example.noteasap.api.MyApiRequest

class UserRepository:MyApiRequest(){
    val myApi= ServiceBuilder.buildServices(UserApi::class.java)

    suspend fun registerUSer(user: User):LoginResponse{
        return apiRequest {
            myApi.userAdd(user)
        }
    }
    suspend fun checkUSer(username:String,password:String):LoginResponse{
        return apiRequest {
            myApi.checkUSer(username,password) }
    }
}