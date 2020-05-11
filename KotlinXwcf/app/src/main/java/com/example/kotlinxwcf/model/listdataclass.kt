package com.example.kotlinxwcf.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class xData(
    @SerializedName("xlista") var lista: MutableList<classUser>?
    //@SerializedName("categories") val categories : List<Categories>
)
