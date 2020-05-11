package com.example.kotlinxwcf.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class classUser(
    @SerializedName("name") var name: String,
    @SerializedName("age") var age: Int
):Serializable