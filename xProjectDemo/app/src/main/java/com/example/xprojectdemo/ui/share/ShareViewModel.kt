package com.example.xprojectdemo.ui.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xprojectdemo.ui.home.mApp

class ShareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is share Fragment"

        mApp.xGlobalsVar.image="popo5"
    }
    val text: LiveData<String> = _text
}