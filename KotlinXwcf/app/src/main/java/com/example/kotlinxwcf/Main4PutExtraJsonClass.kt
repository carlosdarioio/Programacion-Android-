package com.example.kotlinxwcf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinxwcf.model.xData
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main4_put_extra_json_class.*
import kotlin.math.log

class Main4PutExtraJsonClass : AppCompatActivity() {
    var gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4_put_extra_json_class)
        var peoplestring = intent.getSerializableExtra("putuser")
        var people = gson.fromJson(peoplestring.toString(), xData::class.java)
        Log.d("peopleString ",peoplestring.toString())
        Log.d("DataClass ",people.BillingAddressId)
        people.BillingAddressId="Terminamos el ejemplo pasando dataclass en formato json"
        textView2.text="Listo, ${people.BillingAddressId}"
    }
}
