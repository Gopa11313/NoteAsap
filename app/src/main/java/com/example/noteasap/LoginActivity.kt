package com.example.noteasap

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.noteasap.RoomDatabase.db.Db
import com.example.noteasap.RoomDatabase.entity.User
import com.example.noteasap.UI.SignUp.SignUpActivity
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
    private val forget= ForgetpasswordFragment();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        signup=findViewById(R.id.signup)
        forgetpassword=findViewById(R.id.forgetpassword);
        login=findViewById(R.id.login)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
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
                var user: User? = null
                CoroutineScope(Dispatchers.IO).launch {
                    user = Db.getInstance(this@LoginActivity).getUserDao()
                        .checkUSer(email.text.toString(), password.text.toString())
                    if (user != null) {
                        withContext(Main) {
                            Toast.makeText(this@LoginActivity,
                                "Login Successfull",
                                Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        withContext(Main) {
                            Toast.makeText(this@LoginActivity, "Inavalid User", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }
    }
    fun nextact(){
        startActivity(Intent(this, SignUpActivity::class.java))
    }

}