package com.example.noteasapwear

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.User
import com.example.noteasapwear.api.ServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : WearableActivity() {
    private lateinit var email:TextView
    private lateinit var password:TextView
    private lateinit var login:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email=findViewById(R.id.Email)
        password=findViewById(R.id.Password)
        login=findViewById(R.id.login)
         login.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                val repository=UserRepository()
                val response=repository.checkUSer(User(email = email.text.toString(),password = password.text.toString()))
                if(response.success==true){
                    ServiceBuilder.token="Bearer ${response.token}"
                    ServiceBuilder.id=response.id
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity, "${response.id}", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@MainActivity,ViewActivity::class.java))
                    }

                }
            }
         }
        setAmbientEnabled()
    }
}