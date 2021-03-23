package com.example.noteasap.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.ui.forgetPassword.ForgetpasswordFragment
import com.example.noteasap.R
import com.example.noteasap.RoomDatabase.NoteAsapDb
import com.example.noteasap.SecondActivity
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.databinding.ActivityLoginBinding
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.model.User
import com.example.noteasap.ui.signUpViewModel.SignUpActivity
import com.example.noteasap.utils.saveSharedPref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var signup:Button;
    private lateinit var forgetpassword:TextView;
    private lateinit var email:EditText;
    private lateinit var password:EditText;
    private lateinit var login:Button;
    private lateinit var loginViewModel: LoginViewModel
    private val forget= ForgetpasswordFragment();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.lifecycleOwner=this

        signup=findViewById(R.id.signup)
        forgetpassword=findViewById(R.id.forgetpassword);
        login=findViewById(R.id.login)
        email=findViewById(R.id.log_email)
        password=findViewById(R.id.password)

        loginViewModel=ViewModelProvider(this).get(com.example.noteasap.ui.login.LoginViewModel::class.java)
        binding.loginViewModel=loginViewModel

        signup.setOnClickListener(this);
        forgetpassword.setOnClickListener(this);
        login.setOnClickListener(this)

    }

    override fun onClick(p: View?) {
        when(p?.id){
            R.id.signup -> {
                nextact();
            }
            R.id.forgetpassword -> {
                if(forget!=null){
                    getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, forget).commit()
                }
            }
            R.id.login -> {
                login()

            }
        }
    }
    fun nextact(){
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    fun saveSharedPref(){
        val username=email.text.toString()
        val password=password.text.toString()
        val sharedPref=getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor=sharedPref.edit()
        editor.putString("username",username)
        editor.putString("password",password)
        editor.apply()
        Toast.makeText(this@LoginActivity, "Username and password save", Toast.LENGTH_SHORT).show()
    }
    fun login(){
        val user=User(email = email.text.toString(),password = password.text.toString())
        CoroutineScope(Dispatchers.IO).launch {
            val repository=UserRepository()
            val response=repository.checkUSer(user)
            val data=response.data
            val listdata= data?.get(0)
            val name= listdata?.name
            val email=listdata?.email
            if(response.success==true){
                val us=User(_id= response.id!!,email = email,password = password.text.toString())
                NoteAsapDb.getInstance(this@LoginActivity).getUserDao().logout()
                NoteAsapDb.getInstance(this@LoginActivity).getUserDao().RegisterUser(us)
                saveSharedPref(_id = response.id!!, email = email.toString(), password =  password.text.toString(), name =  name.toString())
                ServiceBuilder.token="Bearer ${response.token}"
                ServiceBuilder.id=response.id
                withContext(Main){
                Toast.makeText(this@LoginActivity, "${response.id}", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@LoginActivity,SecondActivity::class.java))
            }
        }
            else{
                withContext(Main){
                    Toast.makeText(this@LoginActivity, "${response.msg}", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}

