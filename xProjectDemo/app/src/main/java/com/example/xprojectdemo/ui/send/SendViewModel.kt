package com.example.xprojectdemo.ui.send

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xprojectdemo.ui.home.mApp

class SendViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is send FragmentZ "+ mApp.xGlobalsVar.image


        mApp.xGlobalsVar.image="popo4"
    }
    val text: LiveData<String> = _text
}