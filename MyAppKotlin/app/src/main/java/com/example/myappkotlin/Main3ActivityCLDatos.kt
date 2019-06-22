package com.example.myappkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Main3ActivityCLDatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3_cldatos)

        //idea peobar si la variable global muestra el nueov valor cambiado desde el loggin
        var mApp = GlobalsVar()
        var strGlobalVar = mApp.globalVar
        Toast.makeText(this@Main3ActivityCLDatos, "Globalx :$strGlobalVar", Toast.LENGTH_LONG).show()
    }
}
