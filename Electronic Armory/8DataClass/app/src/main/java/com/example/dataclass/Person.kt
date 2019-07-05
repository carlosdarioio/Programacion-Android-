package com.example.dataclass

import java.io.Serializable
import java.util.*

data class Person(
    var fname:String,
    var sname:String,
    var age:Int,
    var Bdate: Date=Date()):Serializable {

}