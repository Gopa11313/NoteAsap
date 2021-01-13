package com.example.noteasap.Retrofit

import com.example.noteasap.UI.model.Signup
import retrofit2.Call
import retrofit2.http.*

interface IMyServices {
    @Headers("Content-Type: application/json")
    @POST("/insert")
    fun registerUser(@Body map: HashMap<String, String>): Call<Void?>?

    @POST("/uploadnotes")
    fun uploadNotes(@Body map:HashMap<String,String>):Call<Void?>?

}