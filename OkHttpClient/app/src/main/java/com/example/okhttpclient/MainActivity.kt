package com.example.okhttpclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnget.setOnClickListener {
            getval()
        }

        btnpost.setOnClickListener {
            postval()
        }
    }//Fin Oncreate

    //inicio fun getval
    fun getval() {
        Toast.makeText(this, "Presiono btnget", Toast.LENGTH_SHORT).show()
        //-------------------------------------------------------
        doAsync {
        val url = "http://10.1.0.136:81/SapService.svc/xGetData/lalala"
        val apiResponse = URL(url).readText()
        Respuesta.text=apiResponse
            uiThread {
                //Pasando var animals
                //setUpRecyclerView(animals)
            }
        }
        //-------------------------------------------------------
    }//fin fun getval

    //inicio postval----------------------------------------------------------------------
    fun postval() {
        val url = "http://10.1.0.136:81/SapService.svc/xPostData"
        Toast.makeText(this, "Presiono btnpost", Toast.LENGTH_SHORT).show()



    }//fin gunpostval
    //-----------------------------------------------------------------------------------

}
