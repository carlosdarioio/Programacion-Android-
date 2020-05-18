package com.example.kotlinxwcf

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinxwcf.model.classUser
import kotlinx.android.synthetic.main.activity_main6_start_for_result.*

class Main6StartActivityForResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6_start_for_result)
        var people = intent.getSerializableExtra("putuser") as classUser
        editText.setText(people.name+people.age.toString())
        //cambiar
        button.setOnClickListener {
            people.age=people.age+1
            people.name="Main6StartActivityForResult"
            val result = Intent()
            result.putExtra("putuser", people)
            setResult(Activity.RESULT_OK, result)
            finish()
        }
        //cancrlar
        button2.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }//Fin OnCreate
//Fin ALl

}
