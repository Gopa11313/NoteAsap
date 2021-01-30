package com.example.noteasap.ui.forgetPassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForgetPasswordViewModel:ViewModel(){

    val _Forgetemail=MutableLiveData<String>()

    val forgetemail:LiveData<String>
        get() = _Forgetemail
}