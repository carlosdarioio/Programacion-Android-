package com.example.myappkotlin

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3_cldatos.*

class Main3ActivityCLDatos : AppCompatActivity() {
    var mApp = GlobalsVar()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3_cldatos)
        //idea peobar si la variable global muestra el nueov valor cambiado desde el loggin

        val sharedPref: SharedPreferences = getSharedPreferences(mApp.PREF_USER, mApp.PRIVATE_MODE)
        val user=sharedPref.getString(mApp.PREF_USER,null)

        Toast.makeText(this@Main3ActivityCLDatos, "Bienvenido :$user", Toast.LENGTH_LONG).show()


        val btnArticulos = btnArticulos
        btnArticulos.setOnClickListener {
            val inte= Intent(this,Main3ActivityArticulos::class.java)
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
