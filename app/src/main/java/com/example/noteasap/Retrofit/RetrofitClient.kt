package com.example.noteasap.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitClient {
    private val client = OkHttpClient.Builder().build()
    private var instance: Retrofit?=null;
    fun getInstance():IMyServices{
        if(instance==null){
            instance= Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        }
        return instance!!.create(IMyServices::class.java)
    }
}