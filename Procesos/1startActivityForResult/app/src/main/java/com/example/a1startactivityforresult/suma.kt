package com.example.a1startactivityforresult

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_suma.*

class suma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)

        val num1:Int=intent.getIntExtra("num1",1)
        val num2:Int=intent.getIntExtra("num2",1)

        val r=(num1+num2)

        textView.text="El resultado de $num1 + $num1 es $r"


        mostrar.setOnClickListener {

            val returnIntent:Intent= Intent()
            returnIntent.putExtra("returnsuma",textView.text.toString())
            returnIntent.putExtra("some_new_value",55)


            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }

        cancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }


    }
}
