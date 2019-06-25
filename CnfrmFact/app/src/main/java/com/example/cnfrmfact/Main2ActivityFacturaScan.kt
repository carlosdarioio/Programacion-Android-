package com.example.cnfrmfact

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2_factura_scan.*
import org.json.JSONException
import org.json.JSONObject
import java.util.concurrent.TimeUnit

class Main2ActivityFacturaScan : AppCompatActivity() {
    var mApp = GlobalsVar()
    private val URLstring = "http://10.1.0.136/CFService/Service1.svc/FacturaScan/"
    var user = ""
    var factura = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_factura_scan)

        val sharedPref: SharedPreferences = getSharedPreferences(mApp.PREF_USER, mApp.PRIVATE_MODE)
        user=sharedPref.getString(mApp.PREF_USER,null)
        Toast.makeText(this@Main2ActivityFacturaScan, "Bienvenido "+user, Toast.LENGTH_SHORT).show()


        editnumero.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code
                JSONScanFacture()
                return@OnKeyListener true
            }
            false
        })


        //------
        btnEnviar.setOnClickListener {

            if(editnumero.text.toString()!="")
            {
            JSONScanFacture()
            }
            else
            {
                Toast.makeText(this@Main2ActivityFacturaScan, "rrellenar datos ", Toast.LENGTH_SHORT).show()
            }
        }

        //-------


    }//fin increate

    //JsonObject----------------------
    private fun JSONScanFacture() {

         factura=editnumero.text.toString()
        var url=URLstring+factura+"/"+user
        Toast.makeText(this@Main2ActivityFacturaScan, "test utl "+url, Toast.LENGTH_SHORT).show()
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener { response ->
                Log.d("strrrrr", ">>$response")
                try {

                    val xresponse = JSONObject(response)
                    //arrays
                    //val mJSONArray = xresponse.getJSONArray("contacts")//nombre de objec json
                    //val mJSONObject = mJSONArray.getJSONObject(2)

                    val RespestaJson = xresponse.getString("R")
                    val status = xresponse.getString("status")

                    if(status=="1")//ingresada
                    {
                        txtResult.setTextColor(Color.parseColor("#4444DD"))
                    }
                    else
                    {
                        txtResult.setTextColor(Color.parseColor("#BB4444"))
                    }
                    
                    Toast.makeText(this@Main2ActivityFacturaScan, "Response:$RespestaJson", Toast.LENGTH_LONG).show()
                   
                    txtResult.text=RespestaJson
                    //limpiar txtResult en 5 seconds

                } catch (e: JSONException) {
                    Toast.makeText(this@Main2ActivityFacturaScan, "Errorx ", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error ->
                //displaying the error in toast if occurrs
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            })

        // request queue
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)


        editnumero.text.clear()
    }///Fin JsonObject---------------


    //Borrar label en 5 segundos


    //Fin borrar label en 5 segundos
}
