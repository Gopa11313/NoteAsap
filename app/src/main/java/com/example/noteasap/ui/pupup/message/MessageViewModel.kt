package com.example.noteasap.ui.pupup.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel:ViewModel() {
    val _message = MutableLiveData<String>()

    val  message:LiveData<String>
        get() = _message
}