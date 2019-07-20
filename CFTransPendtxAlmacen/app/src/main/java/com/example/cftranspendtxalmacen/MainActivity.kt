package com.example.cftranspendtxalmacen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun BuscarTransxAlmacen(){
        val xalmacen= almacen.text

        if(xalmacen.toString()=="025" || xalmacen.toString()=="026" || xalmacen.toString()=="002"
           || xalmacen.toString()=="053" || xalmacen.toString()=="007" || xalmacen.toString()=="010")
        {
            val intent = Intent(this, TransfxAlm::class.java)
            intent.putExtra("xalmacen", xalmacen)
            startActivity(intent)

        }
        else
        {
            Toast.makeText(this, "Almacen incorrecto", Toast.LENGTH_SHORT).show()
        }
    }


}
