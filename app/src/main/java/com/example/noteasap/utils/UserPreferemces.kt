package com.example.noteasap.utils

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

fun Activity.saveSharedPref(email:String, password:String,name:String){
    val sharedPref=getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
    val editor=sharedPref.edit()
    editor.putString("name",name)
    editor.putString("email",email)
    editor.putString("password",password)
    editor.apply()

}
fun Activity.getSharedPref() {
    val sharedPref = getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
    val emailPref = sharedPref.getString("email", "")
    val passwordPref = sharedPref.getString("password", "")

}