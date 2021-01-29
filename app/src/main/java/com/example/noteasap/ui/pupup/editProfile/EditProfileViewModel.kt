package com.example.noteasap.ui.pupup.editProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditProfileViewModel:ViewModel() {

    val _name= MutableLiveData<String>()
    val _email= MutableLiveData<String>()
    val _password= MutableLiveData<String>()
    val _conPassword= MutableLiveData<String>()

    val name:LiveData<String>
        get()=_name

    val email:LiveData<String>
        get()=_email

    val password:LiveData<String>
        get()=_password
    val conPassword:LiveData<String>
        get() = _conPassword
    }