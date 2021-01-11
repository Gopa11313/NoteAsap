package com.example.noteasap.SignUp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.noteasap.LoginActivity
import com.example.noteasap.R
import com.example.noteasap.Retrofit.RetrofitClient
import com.example.noteasap.UI.model.Signup
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class SignUpActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var fullname:EditText;
    private lateinit var email:EditText;
    private lateinit var pass:EditText;
    private lateinit var con_pass:EditText;
    private lateinit var termsnCon:CheckBox;
    private  lateinit var register:Button;
    private lateinit var already:TextView;
    private lateinit var reister:Button;
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        fullname=findViewById(R.id.fullName)
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        con_pass=findViewById(R.id.con_pss)
        pass=findViewById(R.id.pass);
        termsnCon=findViewById(R.id.termsnCon);
        reister=findViewById(R.id.reister)
        register=findViewById(R.id.reister);
        already=findViewById(R.id.already)
        register.setOnClickListener(this);
        already.setOnClickListener(this);
        register.setOnClickListener {
            if(validate()==true){
                val Signup1=Signup(1,fullname.toString(),email.toString(),pass.toString(),"")
                var regist= RetrofitClient.getInstance().registerUser(Signup1)
                regist.enqueue(object: retrofit2.Callback<Signup>{
                    override fun onResponse(call: Call<Signup>, response: Response<Signup>) {
                        if(response.code()==200){
                            if(response.code()==200){
                                Toast.makeText(this@SignUpActivity,"User registered successfully",Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(this@SignUpActivity,response.errorBody().toString(),Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<Signup>, t: Throwable) {
                        Toast.makeText(this@SignUpActivity,t.localizedMessage,Toast.LENGTH_LONG).show()
                    }

                })
            }
        }
    }

    override fun onClick(p: View?) {
        when(p?.id){
            R.id.reister->{
                validate()
            }
            R.id.already->{
                nextact()
            }
        }
    }
    fun validate():Boolean {
        var flag:Boolean
        val pas = pass.text.toString();
        val cpass = con_pass.text.toString();
        val em =email.text.toString()
            if (em.matches(emailPattern.toRegex())) {
                if(pas==cpass){
                    if(termsnCon.isChecked){
                        Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show()
                        flag=true;
                    }
                    else{
                        Toast.makeText(this,"Please check the terms and condition button.",Toast.LENGTH_LONG).show();
                        flag=false;
                    }
                }
                else{
                    Toast.makeText(this,"Password and con-password is not matched",Toast.LENGTH_LONG).show()
                    flag=false
                }
            }
        else{
                Toast.makeText(this, "invalid emaial", Toast.LENGTH_SHORT).show()
                flag=false
            }
        return flag
    }
    fun nextact(){
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}