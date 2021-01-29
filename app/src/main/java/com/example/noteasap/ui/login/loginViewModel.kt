package com.example.noteasap.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class loginViewModel:ViewModel() {

    val _email=MutableLiveData<String>()
    val _password=MutableLiveData<String>()

    val email:LiveData<String>
        get() = _email

    val password:LiveData<String>
        get()=_password
}