package com.example.noteasap.UI.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel:ViewModel() {
    val _fullname=MutableLiveData<String>()
    val _email=MutableLiveData<String>()
    val _password=MutableLiveData<String>()

    val fullname:LiveData<String>
        get() = _fullname

    val email:LiveData<String>
        get() = _email

    val password:LiveData<String>
        get()=_password

}