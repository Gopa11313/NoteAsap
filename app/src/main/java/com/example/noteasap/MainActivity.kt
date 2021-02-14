package com.example.noteasap.ui.model

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.noteasap.R
import com.example.noteasap.SecondActivity

private lateinit var note:TextView;
private lateinit var fadein:Animation;
private lateinit var slogan:TextView;
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        note=findViewById(R.id.note)
        slogan=findViewById(R.id.slogan)
//        slogan=null;
        fadein=AnimationUtils.loadAnimation(this, R.anim.fade_in)
        note.startAnimation(fadein)
        slogan.startAnimation(fadein)
            Handler(Looper.getMainLooper()).postDelayed({
                stratactivity()
            }, 2500)
    }
    fun stratactivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        finish()
    }

}