package com.example.noteasap

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Layout
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.login.LoginActivity
import com.example.noteasap.ui.model.User
import com.example.noteasap.ui.thirdActivity.Third_Activity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import java.io.IOException


class SplashActivity : AppCompatActivity() {
    private lateinit var note:TextView;
    private lateinit var fadein:Animation;
    private lateinit var slogan:TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        note = findViewById(R.id.note)
        slogan = findViewById(R.id.slogan)
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        note.startAnimation(fadein)
        slogan.startAnimation(fadein)
        val sharedPref = getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
        val emailPref = sharedPref.getString("email", null)
        val passwordPref = sharedPref.getString("password", "")

        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            if (emailPref != null) {
                withContext(Main){
                    Toast.makeText(this@SplashActivity, "$emailPref + ", Toast.LENGTH_SHORT).show()
                    val repository = UserRepository()
                    val user = User(email = emailPref, password = passwordPref)
                    val response = repository.checkUSer(user)
                    if (response.success == true) {
                        ServiceBuilder.token="Bearer ${response.token}"
                        ServiceBuilder.id=response.id
                        delay(500)
                        startActivity(Intent(this@SplashActivity, SecondActivity::class.java)
                        )
                        finish()
                    }
                }
            } else {
                withContext(Main){
                    startActivity(
                        Intent(
                            this@SplashActivity,
                            LoginActivity::class.java
                        )
                    )
                }
                finish()
            }
        }

//    fun stratactivity() {
//        startActivity(Intent(this,LoginActivity::class.java))
//        finish()
//    }

    }
}

