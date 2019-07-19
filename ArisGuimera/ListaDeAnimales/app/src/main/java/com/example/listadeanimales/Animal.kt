package com.example.listadeanimales

import java.io.Serializable

data class Animal (
    val name:String,
    val description:String,
    val image:String
):Serializable