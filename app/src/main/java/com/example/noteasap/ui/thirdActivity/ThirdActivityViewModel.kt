package com.example.noteasap.ui.thirdActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThirdActivityViewModel:ViewModel() {
    private val _currentfragment = MutableLiveData<Fragment>().apply {
        value = Fragment.HOME
    }
    val fragment: LiveData<Fragment> = _currentfragment

    fun setFragment(fragment: Fragment){
        _currentfragment.apply {
            value = fragment;
        }
    }

    fun getFragment(): Fragment? {
        return _currentfragment.value
    }

    enum class Fragment{
        HOME, BOOKMARK, ACCOUNT
    }

}