package com.example.myappkotlin

import android.app.Application

class GlobalsVar : Application() {
    //Valores generales que puedas ocupar
    //no son editables
    var globalVar = "I am Global Variable"

    //Asignando variables de SharedPreferences
    var PRIVATE_MODE = 0
    val PREF_NAME = "mindorks-welcome"
    val PREF_USER = "USERS"//session user


}