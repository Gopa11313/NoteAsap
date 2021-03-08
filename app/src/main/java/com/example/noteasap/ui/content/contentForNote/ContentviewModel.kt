package com.example.noteasap.ui.content.contentForNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContentviewModel:ViewModel() {

    val _topic= MutableLiveData<String>()

    val _uniName =MutableLiveData<String>()

    val _dis=MutableLiveData<String>()

    val _rating =MutableLiveData<Int>()

    val _cmnt =MutableLiveData<String>()



    val topic:LiveData<String>
        get() = _topic

    val uniName:LiveData<String>
        get()=_uniName

    val dis:LiveData<String>
        get() = _dis

    val rating:LiveData<Int>
        get()=_rating

    val cmnt:LiveData<String>
        get() = _cmnt


//    var Setrating:LiveData<Int>
//        get() {
//            TODO()
//        }
//        set()=_rating

}