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
        almacen.setText("025")
        btnBuscar.setOnClickListener {
            BuscarTransxAlmacen()
        }
    }


    public fun BuscarTransxAlmacen(){
        val xalmacen:String= almacen.text.toString()

if(xalmacen=="025" ||
   xalmacen=="026" ||
   xalmacen=="002" ||
   xalmacen=="053" ||
   xalmacen=="007" ||
   xalmacen=="010")
        {   var intent = Intent(this, TransfxAlm::class.java)
            intent.putExtra("xalmacen", xalmacen)
            startActivity(intent)
            finish();
        }
        else
        {
            Toast.makeText(this, "Almacen incorrecto", Toast.LENGTH_SHORT).show()
        }
    }


}
