package com.example.noteasap.api

import com.example.noteasap.response.SignupResponse
import com.example.noteasap.ui.model.User
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @POST("/insert")
    fun registerUser(@Body user: User):Response<SignupResponse>

    @FormUrlEncoded
    @POST("user/login")
    suspend fun checkUSer(
        @Field("email")  email:String,
        @Field("password") paword:String,
    ):Response<SignupResponse>

}