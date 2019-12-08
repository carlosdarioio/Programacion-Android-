package com.example.xprojectdemo.ui.tools

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xprojectdemo.ui.home.mApp

class ToolsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is tools Fragment"

        mApp.xGlobalsVar.image="popo3"
    }
    val text: LiveData<String> = _text

}