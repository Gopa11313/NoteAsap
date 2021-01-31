package com.example.noteasap.ui.fragments.homeFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class HomeFragmetViewModel:ViewModel() {
    val _autocmptText =MutableLiveData<String>()

    val autocmptText:LiveData<String>
        get() = _autocmptText


}