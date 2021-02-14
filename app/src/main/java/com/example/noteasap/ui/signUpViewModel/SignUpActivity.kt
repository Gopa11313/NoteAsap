package com.example.noteasap.ui.signUpViewModel


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.ui.login.LoginActivity
import com.example.noteasap.R
import com.example.noteasap.databinding.ActivitySignUpBinding
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.response.UserResponse
import com.example.noteasap.ui.model.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var fullname:EditText;
    private lateinit var email:EditText;
    private lateinit var pass:EditText;
    private lateinit var con_pass:EditText;
    private lateinit var termsnCon:CheckBox;
    private lateinit var signup:LinearLayout;
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
        signup=findViewById(R.id.signup)
        already=findViewById(R.id.already)
        already.setOnClickListener(this);
        signupViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding.signUpViewModel=(signupViewModel)
        register.setOnClickListener {
           adduser()
            //addUSerInRoomDatabse()
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
            val user= User(name = fullname.text.toString(),email = email.text.toString(),password = pass.text.toString(),image = "")
            try{
            CoroutineScope(Dispatchers.IO).launch {
                val repository=UserRepository()
                val response=repository.registerUser(user)
                if(response.success==true){
                    withContext(Dispatchers.Main) {

                        val snack=  Snackbar.make(signup,"${response.msg}", Snackbar.LENGTH_SHORT)
                        snack.setAction("Ok") {
                            snack.dismiss()
                        }
                        snack.show()
                        clear()
                    }
                }
                else{
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@SignUpActivity, "${response.msg}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            }catch (e:Exception){
                Toast.makeText(this, "${e.toString()}", Toast.LENGTH_SHORT).show()
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