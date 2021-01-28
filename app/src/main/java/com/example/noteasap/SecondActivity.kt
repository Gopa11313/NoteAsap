package com.example.noteasap

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.example.noteasap.UI.thirdActivity.Third_Activity

private lateinit var notif: Button;
var flag=false;
class SecondActivity : AppCompatActivity() {
    private val permissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        notif=findViewById(R.id.notif_Button);
        if (!hasPermission()) {
            requestPermission()
        }
        notif.setOnClickListener(){
            flag=true;
            nexatact();
        }
    }
    fun nexatact(){
        startActivity(Intent(this, Third_Activity::class.java))
        finish();
    }
    fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@SecondActivity,
            permissions, 876
        )
    }
    fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
            }
        }
        return hasPermission
    }
}