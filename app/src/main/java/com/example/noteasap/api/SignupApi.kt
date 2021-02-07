package com.example.noteasap.api

import retrofit2.Call
import retrofit2.http.*

interface SignupApi {
    @Headers("Content-Type: application/json")
    @POST("/insert")
    fun registerUser(@Body map: HashMap<String, String>): Call<Void?>?

    @POST("/uploadnotes")
    fun uploadNotes(@Body map:HashMap<String,String>):Call<Void?>?

}