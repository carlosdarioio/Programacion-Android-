package com.example.myappkotlin

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main2_loggin.*
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class Main2ActivityLoggin : AppCompatActivity() {

    //url
    private val URLstring = "http://10.1.0.136/CFService/Service1.svc/Getusers/"
    private var listView: ListView? = null
    //internal var dataModelArrayList: ArrayList<UserModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_loggin)


        val btnenter = findViewById<Button>(R.id.btnentrar)
        val user = contra
        val psd = usuario //asignando sin findViewById<xxx>(R.id.xxx)
        btnenter.setOnClickListener {

        //JSONuserLoggin()


        }
    }//fin oncreate

//****************************************idera pasar user y password como string a server osea
    //JsonObject----------------------
private fun JSONuserLoggin() {

    //showSimpleProgressDialog(this, "Loading...", "Fetching Json", false)

    val stringRequest = StringRequest(
        Request.Method.GET, URLstring,
        Response.Listener { response ->
            Log.d("strrrrr", ">>$response")

            try {

                val obj = JSONObject(response)
                //comprobando respuesta del loggin
                if (obj.optString("status") == "true")
                {
                    val dataArray = obj.getJSONArray("users")//nombre de objec json
                }

            } catch (e: JSONException) {
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

    ///Fin JsonObject---------------


}
