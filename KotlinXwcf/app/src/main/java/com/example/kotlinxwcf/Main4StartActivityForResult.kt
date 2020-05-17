package com.example.kotlinxwcf

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinxwcf.model.classUser
import kotlinx.android.synthetic.main.activity_main4_start_for_result.*

class Main4StartActivityForResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4_start_for_result)
        var people = intent.getSerializableExtra("putuser") as classUser

        // 1
        editText.setText(people.name)

//cambiar
button.setOnClickListener {
    people.age=people.age+1
    people.name="Main4StartActivityForResult"
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


    }//Fin Oncreate
}
