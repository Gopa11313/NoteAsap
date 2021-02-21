package com.example.noteasap.api

import androidx.room.Update
import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.User
import retrofit2.Response
import retrofit2.http.*

interface UserApi {
    @POST("user/add")
    suspend fun registerUSer(@Body users: User):Response<UserResponse>

    @POST("user/login")
    suspend fun checkUSer(
        @Body users: User
    ):Response<UserResponse>


//    @PUT("/user/update/{UserID}")
//    suspend fun updateUser(@Path("id") String id)
}