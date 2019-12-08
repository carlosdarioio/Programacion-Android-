package com.example.xprojectdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xprojectdemo.GlobalsVar
var mApp = GlobalsVar()
class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment "+mApp.xGlobalsVar.image


        mApp.xGlobalsVar.image="popo2"
    }
    val text: LiveData<String> = _text






}
