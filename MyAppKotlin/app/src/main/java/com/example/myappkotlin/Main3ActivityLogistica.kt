package com.example.myappkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3_logistica.*

class Main3ActivityLogistica : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3_logistica)

        val btnCL = btnCLDatos
        btnCL.setOnClickListener {
            val inte= Intent(this,Main3ActivityCLDatos::class.java)
            startActivity(inte)
            finish();
        }

        val btnArticulos = btnArticulos
        btnArticulos.setOnClickListener {
            val inte= Intent(this,Main3ActivityArticulos::class.java)
            startActivity(inte)
            finish();
        }
    }
}
