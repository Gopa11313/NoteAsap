package com.example.noteasap.api

import com.example.noteasap.response.SignupResponse
import com.example.noteasap.ui.model.Signup
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface SignupApi {

    @POST("/insert")
    fun registerUser(@Body signup: Signup):Response<SignupResponse>

    @FormUrlEncoded
    @POST("user/login")
    suspend fun checkUSer(
        @Field("email")  email:String,
        @Field("password") paword:String,
    ):Response<SignupResponse>

}