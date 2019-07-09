package com.example.a3getjsoninclass.DATA

data class users(val status: String,val message: String, var list: List<Lusers>?)
data class Lusers(val DocEntry: String, val docnum: String, val CardCode: String, val CardName: String)
