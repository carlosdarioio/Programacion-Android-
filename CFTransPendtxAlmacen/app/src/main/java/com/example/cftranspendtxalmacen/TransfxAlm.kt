package com.example.cftranspendtxalmacen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class TransfxAlm : AppCompatActivity() {
//cargando lista de transferencia del almacen puesto
    var almacen=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfx_alm)

    if(intent !=null) {
        almacen=intent.extras.getString("xalmacen")

        Toast.makeText(this, "Almacen Ingresado:  ", Toast.LENGTH_SHORT).show()
    }


    }
}
