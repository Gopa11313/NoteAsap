package com.example.noteasap.ui.forgetPassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel:ViewModel(){

    val _email=MutableLiveData<String>()

    val email:LiveData<String>
        get() = _email
}