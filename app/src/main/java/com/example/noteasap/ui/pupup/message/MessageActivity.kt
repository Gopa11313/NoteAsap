package com.example.noteasap.ui.pupup.message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.R
import com.example.noteasap.databinding.ActivityLoginBinding
import com.example.noteasap.ui.login.LoginViewModel

class MessageActivity : AppCompatActivity() {
    private lateinit var message:EditText;
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding:ActivityLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_message)
        binding.lifecycleOwner=this
        message=findViewById(R.id.message)
        loginViewModel=ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel=loginViewModel
    }
}