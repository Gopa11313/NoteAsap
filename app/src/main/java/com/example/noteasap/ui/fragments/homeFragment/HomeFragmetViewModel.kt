package com.example.noteasap.ui.fragments.homeFragment

import android.widget.AutoCompleteTextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class HomeFragmetViewModel:ViewModel() {
    val _autocmptText =MutableLiveData<String>()

    val attemptText:LiveData<String>
        get() = _autocmptText


}