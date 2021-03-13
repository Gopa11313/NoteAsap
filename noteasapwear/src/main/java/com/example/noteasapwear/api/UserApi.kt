package com.example.noteasapwear.api

import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("user/login")
    suspend fun checkUSer(
        @Body users: User
    ): Response<UserResponse>
}