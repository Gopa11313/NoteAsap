package com.example.noteasap.ui.signUpViewModel


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.ui.login.LoginActivity
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.databinding.ActivitySignUpBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response

class SignUpActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var fullname:EditText;
    private lateinit var email:EditText;
    private lateinit var pass:EditText;
    private lateinit var con_pass:EditText;
    private lateinit var termsnCon:CheckBox;
    private  lateinit var register:Button;
    private lateinit var signupViewModel: SignUpViewModel
    private lateinit var already:TextView;
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivitySignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.lifecycleOwner = this

        fullname=findViewById(R.id.fullName)
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        con_pass=findViewById(R.id.con_pss)
        pass=findViewById(R.id.pass);
        termsnCon=findViewById(R.id.termsnCon);
        register=findViewById(R.id.reister)
        already=findViewById(R.id.already)
        already.setOnClickListener(this);
        signupViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding.signUpViewModel=(signupViewModel)
        register.setOnClickListener {
//            adduser()
            addUSerInRoomDatabse()
        }
    }

    override fun onClick(p: View?) {
        when(p?.id){
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
                Toast.makeText(this, "invalid email", Toast.LENGTH_SHORT).show()
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
    fun adduser(){
        if(validate()==true){
            val map = HashMap<String, String>()
            map["name"] = fullname.text.toString()
            map["email"] = email.text.toString()
            map["password"]=pass.text.toString()
            map["image"]=""
            val call: Call<Void?>? = ServiceBuilder.getInstance().registerUser(map)
            if (call != null) {
                call.enqueue(object: retrofit2.Callback<Void?>{
                    override fun onResponse(call:Call<Void?>?, response: Response<Void?>) {
                        if(response.code()==200){
                            if(response.code()==200){
                                Toast.makeText(this@SignUpActivity,"User registered successfully",Toast.LENGTH_SHORT).show()
                                Handler(Looper.getMainLooper()).postDelayed({
                                    clear()
                                }, 1000)
                            }else{
                                Toast.makeText(this@SignUpActivity,response.errorBody().toString(),Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    override fun onFailure(call: Call<Void?>?, t: Throwable) {
                        Toast.makeText(this@SignUpActivity,t.localizedMessage,Toast.LENGTH_LONG).show()
                    }
                })
            }
        }

    }
    fun clear(){
        fullname.setText("")
        email.setText("")
        pass.setText("")
        con_pass.setText("")
        termsnCon.isChecked=false
    }
    fun addUSerInRoomDatabse(){
//        val user=User(fullname.text.toString(),email.text.toString(),pass.text.toString())
//        CoroutineScope(Dispatchers.IO).launch {
//            Db.getInstance(this@SignUpActivity).getUserDao().AddUSer(user)
//            withContext(Main){
//                Toast.makeText(this@SignUpActivity, "Register Succefully", Toast.LENGTH_SHORT).show()
//
//            }
//        }
    }


}