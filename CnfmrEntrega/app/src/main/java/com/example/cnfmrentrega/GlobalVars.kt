package com.example.cnfmrentrega

import android.app.Application

class GlobalsVar : Application() {
    //Valores generales que puedas ocupar
    //no son editables
    var globalVar = "I am Global Variable"

    //Asignando variables de SharedPreferences
    var PRIVATE_MODE = 0
    var DocEntry = "DocEntry"
    var DocNum = "DocNum"
    var CardCode = "CardCode"//session user
    var CardName = "CardName"//session user


}