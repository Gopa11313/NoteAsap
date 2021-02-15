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
        email=findViewById(R.id.email)
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
        Toast.makeText(this@LoginActivity, "${email.text.toString()+password.text.toString()}", Toast.LENGTH_SHORT).show()
        val user=User(email = email.text.toString(),password = password.text.toString())
        CoroutineScope(Dispatchers.IO).launch {
            val repository=UserRepository()
            val response=repository.checkUSer(user)
            val data=response.data
            val us: List<User>? =data
            if(response.success==true){
                NoteAsapDb.getInstance(this@LoginActivity).getUserDao().RegisterUser(us)
                ServiceBuilder.token=response.token
                withContext(Main){
                Toast.makeText(this@LoginActivity, "${response.msg}", Toast.LENGTH_SHORT).show()
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


//var user: User? = null
//                CoroutineScope(Dispatchers.IO).launch {
//                    user = Db.getInstance(this@LoginActivity).getUserDao()
//                        .checkUSer(email.text.toString(), password.text.toString())
//                    if (user != null) {
//
//                        withContext(Main) {
//                            Toast.makeText(this@LoginActivity, "Login Successfull",Toast.LENGTH_SHORT).show()
//
//                            val builder= AlertDialog.Builder(this@LoginActivity);
//                            builder.setMessage("Do You Want to Save this email and password!!")
//                            builder.setIcon(android.R.drawable.ic_dialog_alert);
//                            builder.setPositiveButton("Yes"){dialogInterface,which->
//                                saveSharedPref()
//                            }
//
//                            builder.setNeutralButton("Calcel"){dialogInterface,which->
//
//                            }
//                            builder.setNegativeButton("No"){
//                                    dialogInterface,which->
//
//                            }
//                            val alertDialog: AlertDialog =builder.create()
//                            alertDialog.setCancelable(false)
//                            alertDialog.show()
//                        }
//                    } else {
//                        withContext(Main) {
//                            Toast.makeText(this@LoginActivity, "Inavalid User", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }