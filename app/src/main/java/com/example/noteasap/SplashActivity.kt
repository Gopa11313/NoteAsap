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
import com.example.noteasap.ui.login.LoginActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

private lateinit var note:TextView;
private lateinit var fadein:Animation;
private lateinit var slogan:TextView;
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        note = findViewById(R.id.note)
        slogan = findViewById(R.id.slogan)
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        note.startAnimation(fadein)
        slogan.startAnimation(fadein)

        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            withContext(Main) {

                stratactivity()
            }
        }
    }

    fun stratactivity() {
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    fun getSharedPref() {
        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        val password = sharedPref.getString("password", "")
        Toast.makeText(this, "Username:$username and Password:$password", Toast.LENGTH_SHORT).show()
    }

}

