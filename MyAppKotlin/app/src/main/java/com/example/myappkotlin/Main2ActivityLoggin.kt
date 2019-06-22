package com.example.myappkotlin

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
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
    //private val URLstring = "http://10.1.0.136/CFService/Service1.svc/Getusers/"
    private val URLstring = "https://api.androidhive.info/contacts/"
    private var listView: ListView? = null
    //internal var dataModelArrayList: ArrayList<UserModel>
    var mApp = GlobalsVar()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_loggin)

        //var mApp = GlobalsVar()
        mApp.globalVar="alola"
        var strGlobalVar = mApp.globalVar
        Toast.makeText(this@Main2ActivityLoggin, "Global :$strGlobalVar", Toast.LENGTH_LONG).show()




        val btnenter = findViewById<Button>(R.id.btnentrar)
        val user = contra
        val psd = usuario //asignando sin findViewById<xxx>(R.id.xxx)
        btnenter.setOnClickListener {

            JSONuserLoggin()


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
                    //Pendiente programar service que resiva user y password si la repsuesta es correcta que abra el intent
                    //por aqui vas buscar como guardar usuario que ingreso localmente
                    //ya q el usuario se enviara cuando cree el pedido

                    //Pendiente Crear CLDatos, CLArticulos y CLLogist
                    val xresponse = JSONObject(response)
                    val mJSONArray = xresponse.getJSONArray("contacts")//nombre de objec json
                    val mJSONObject = mJSONArray.getJSONObject(2)
                    val name = mJSONObject.getString("name")
                    Toast.makeText(this@Main2ActivityLoggin, "Nombre:$name", Toast.LENGTH_LONG).show()

                    //....
                    //aqui obtendria el resultado del json donde comprobaria si el user y contra son correctos
                    // mejor mandar desde el server true o false pa q deje entrar
                    if(1==1)
                    {
                        val inte= Intent(this,Main3ActivityCLDatos::class.java)
                        startActivity(inte)
                        finish()
                    }
                    //....

                } catch (e: JSONException) {
                    Toast.makeText(this@Main2ActivityLoggin, "Errorx ", Toast.LENGTH_LONG).show()
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

    }///Fin JsonObject---------------



}//Fin AppCompatActivity
