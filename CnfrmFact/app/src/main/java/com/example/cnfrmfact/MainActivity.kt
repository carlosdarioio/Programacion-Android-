package com.example.cnfrmfact

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var mApp = GlobalsVar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrar.setOnClickListener {

            GetuserLoggin()


        }
    }//Fin Oncreate

    //JsonObject----------------------
    private fun GetuserLoggin() {
        //si la rsspuesta json del loggin es correcta asignamos el user a PREF_USER
        val user = txtuser
        var contra = txtcontra

        if(user.text.toString()=="admin" && contra.text.toString()=="admin")
        {
            val sharedPref: SharedPreferences = getSharedPreferences(mApp.PREF_USER, mApp.PRIVATE_MODE)
            val editor = sharedPref.edit()
            editor.putString(mApp.PREF_USER, user.text.toString())
            editor.commit()

            val inte= Intent(this,Main2ActivityFacturaScan::class.java)
            startActivity(inte)
            finish()

        }
        else
        {
            Toast.makeText(this@MainActivity, "Usuario/Contra incorrecta ", Toast.LENGTH_SHORT).show()
        }





    }///Fin JsonObject---------------
}
