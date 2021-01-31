package com.example.noteasap.ui.uploadNotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UploadNotesViewModel:ViewModel() {
    val _cName=MutableLiveData<String>()

    val _topic=MutableLiveData<String>()

    val _desc=MutableLiveData<String>()

    val cName:LiveData<String>
        get()=_cName

    val topic:LiveData<String>
        get()=_topic

    val desc:LiveData<String>
        get() = _desc
}