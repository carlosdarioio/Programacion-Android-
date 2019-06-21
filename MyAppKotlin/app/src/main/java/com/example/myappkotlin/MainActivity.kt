package com.example.myappkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2_loggin.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnloggin = findViewById<Button>(R.id.btnloggin)
        btnloggin.setOnClickListener {
            Toast.makeText(this@MainActivity, "Its MainActivity!", Toast.LENGTH_SHORT).show()
            val inte= Intent(this,Main2ActivityLoggin::class.java)
            startActivity(inte)
            finish();
        }
    }
}
