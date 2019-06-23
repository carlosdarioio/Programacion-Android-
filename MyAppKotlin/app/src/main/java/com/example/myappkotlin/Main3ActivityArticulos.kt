package com.example.myappkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3_articulos.*


class Main3ActivityArticulos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3_articulos)


        val btnCL = btnCLDatos
        btnCL.setOnClickListener {
            val inte= Intent(this,Main3ActivityCLDatos::class.java)
            startActivity(inte)
            finish();
        }

        val btLogis = btnLogis
        btLogis.setOnClickListener {
            val inte= Intent(this,Main3ActivityLogistica::class.java)
            startActivity(inte)
            finish();
        }
    }
}
