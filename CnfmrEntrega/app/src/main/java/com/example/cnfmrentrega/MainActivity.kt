package com.example.cnfmrentrega

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var mApp = GlobalsVar()
    //url para buscar factura(ver si exuste)
    private var URLstring = "http://10.1.0.136/CFService/SapService.svc/FindFactura/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBuscar.setOnClickListener {


            var txtxl=txtfactura.text.toString()
            Toast.makeText(this@MainActivity, "entra ", Toast.LENGTH_LONG).show()
            val stringRequest = StringRequest(
                //asignando valores falta poner el del user que entra
                Request.Method.GET, URLstring+txtxl+"/Venta07",
                Response.Listener { response ->
                    Log.d("strrrrr", ">>$response")
                    try {

                        val xresponse = JSONObject(response)

                        //obteniendo status para verificar estado de la busqueda
                        val status = xresponse.getString("status")
                        if(status=="0")
                        {
                            Toast.makeText(this@MainActivity, "Sin Resultados ", Toast.LENGTH_LONG).show()

                        }
                        else if(status=="1")
                        {
                            /*esto lo ocupas cuando seleccione factura
                            var sharedPref: SharedPreferences = getSharedPreferences(mApp.DocEntry, mApp.PRIVATE_MODE)
                            var editor = sharedPref.edit()

                            editor.putString(mApp.DocEntry, xresponse.getString("DocEntry"))
                            editor.commit()

                            sharedPref = getSharedPreferences(mApp.CardName, mApp.PRIVATE_MODE)
                            editor = sharedPref.edit()

                            editor.putString(mApp.CardName, xresponse.getString("CardName"))
                            editor.commit()*/

                            //si encontro 1 O MAS  resultados lo redirecciona a MainActivity2ListOinv para que le de clicj a la que ocupa
                            val intent = Intent(this, MainActivity2ListOinv::class.java)
                            intent.putExtra("factura", txtxl)//asignando valor de factura a buscar
                            startActivity(intent)



                        }

                    } catch (e: JSONException) {
                        Toast.makeText(this@MainActivity, "Errorx ", Toast.LENGTH_LONG).show()
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


        }


    }//fin oncreate


    //JsonObject----------------------
    ///Fin JsonObject---------------


}
