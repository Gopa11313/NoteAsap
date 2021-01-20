package com.example.noteasap

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Layout
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private lateinit var note:TextView;
private lateinit var fadein:Animation;
private lateinit var slogan:TextView;
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        note=findViewById(R.id.note)
        slogan=findViewById(R.id.slogan)
        fadein=AnimationUtils.loadAnimation(this, R.anim.fade_in)
        note.startAnimation(fadein)
        slogan.startAnimation(fadein)
            CoroutineScope(Dispatchers.IO).launch {
                delay(2500)
                stratactivity()
            }
    }
    fun stratactivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        finish()
    }

}