package com.example.noteasap.api

import androidx.room.Update
import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.User
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface UserApi {
    @POST("user/add")
    suspend fun registerUSer(@Body users: User):Response<UserResponse>

    @POST("user/login")
    suspend fun checkUSer(
        @Body users: User
    ):Response<UserResponse>


    @Multipart
    @PUT("upload/user/image/{id}")
    suspend fun uploadImage(
        @Header("Authorization") token:String,
        @Path("id") id:String,
        @Part file: MultipartBody.Part
    ): Response<UserResponse>

    @GET("get/me/{id}")
    suspend fun getme(
        @Header("Authorization") token:String,
        @Path("id") id:String,
    ):Response<UserResponse>


    @PUT("user/update/{UserID}")
    suspend fun updateUser(
        @Header("Authorization") token:String,
        @Body users: User
    ):Response<UserResponse>
}