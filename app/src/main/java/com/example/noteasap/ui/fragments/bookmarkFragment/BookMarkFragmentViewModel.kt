package com.example.noteasap.ui.fragments.bookmarkFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookMarkFragmentViewModel:ViewModel() {
    val _search=MutableLiveData<String>()

    val search:LiveData<String>
        get() = _search
}