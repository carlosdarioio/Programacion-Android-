package com.example.kotlinxwcf.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class xData2(
    @SerializedName("categories") val categories : List<classUser>
)
