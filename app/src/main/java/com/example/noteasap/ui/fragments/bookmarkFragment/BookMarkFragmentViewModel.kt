package com.example.noteasap.ui.fragments.bookmarkFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookMarkFragmentViewModel:ViewModel() {
    val _search=MutableLiveData<String>()

    val search:LiveData<String>
        get() = _search

/////Need to looktrough once

//    val user = MutableLiveData("")
//    var userList: MutableLiveData<ArrayList<User>> = MutableLiveData()
//
//    val valid = MediatorLiveData<Boolean>().apply {
//        addSource(user) {
//            searchUser(it)
//            value = true
//        }
//    }
//
//    private fun searchUser(name: String) {
//        CoroutineScope(Dispatchers.Main).launch {
//            try {
//                val response = repository.searchUser(name)
//                if(response.isSuccessful){
//                    userList.value = response.body()?.items
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
}