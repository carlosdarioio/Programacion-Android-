package com.example.myappkotlin

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main2_loggin.*
import kotlinx.android.synthetic.main.activity_main3_cldatos.*
import org.json.JSONException
import org.json.JSONObject

class Main3ActivityCLDatos : AppCompatActivity() {
    var mApp = GlobalsVar()
    //creando getcldatos OCRD
    private val URLstring = "http://10.1.0.136/CFService/Service1.svc/FindCLByName/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3_cldatos)
        //idea peobar si la variable global muestra el nueov valor cambiado desde el loggin

        val sharedPref: SharedPreferences = getSharedPreferences(mApp.PREF_USER, mApp.PRIVATE_MODE)
        val user=sharedPref.getString(mApp.PREF_USER,null)

        Toast.makeText(this@Main3ActivityCLDatos, "Bienvenido :$user", Toast.LENGTH_LONG).show()


        val btnArticulos = btnArticulos
        btnArticulos.setOnClickListener {
            val inte= Intent(this,Main3ActivityArticulos::class.java)
            startActivity(inte)
            finish();
        }

        val btLogis = btnLogis
        btLogis.setOnClickListener {
            val inte= Intent(this,Main3ActivityLogistica::class.java)
            startActivity(inte)
            finish();
        }

        //por aqui vas si el texto de txtClient  no es vavio buscar cl con el texto puest
        //si solo alla 1 asignar valores a los textos e insertar los datos en la tabla
        //si alla mas de uno abrir lista mostrando resultados(ver Main5ActivityVolleyList)
        //cuando le de clic a uno que ingrese lo ingrese en la tabla y seleccione

        //Crear ListAdapter pones cod del cl si solo es un resultado
        //que lo inserte y rellene
        //si son bastantes direccionar al ListAdapter y que inserte y rellene el que seleccione
        //desde el ListAdapter
        //Ejemplo kotlin: https://www.youtube.com/watch?v=KFo1bO05Jho
        var xbtnFindCl=btnFindCl

        xbtnFindCl.setOnClickListener {

            JSONuserLoggin()


        }//fin btnFindCl
    }//ifn oncreate


    //JsonObject----------------------
    private fun JSONuserLoggin() {

        //showSimpleProgressDialog(this, "Loading...", "Fetching Json", false)
        var txtxl=txtCL.text.toString()

        val stringRequest = StringRequest(
            Request.Method.GET, URLstring+txtxl,
            Response.Listener { response ->
                Log.d("strrrrr", ">>$response")
                try {
                    val xresponse = JSONObject(response)
                    val mJSONArray = xresponse.getJSONArray("users")//nombre de objec json
                    val mJSONObject = mJSONArray.getJSONObject(0)
                    val name = mJSONObject.getString("CardName")
                    Toast.makeText(this@Main3ActivityCLDatos, "CardName:$name", Toast.LENGTH_LONG).show()

                    //un reusltado
                    val status = xresponse.getString("status")

                    //....
                    if(status=="1")//asignanr valores
                    {
                        //pendiente insertar dato allado a la tabla sqli
                        txtCL.setText(mJSONObject.getString("CardCode"))
                        txtName.setText(mJSONObject.getString("CardName"))
                    }
                    else if(status=="2")//mostrra lista
                    {
                        val sharedPref: SharedPreferences = getSharedPreferences(mApp.PREF_USER, mApp.PRIVATE_MODE)
                        val editor = sharedPref.edit()
                        //si la rsspuesta json del loggin es correcta asignamos el user a PREF_USER
                        //nota crear varuable global de cl que la que estas usando es la de user:mApp.PREF_USER
                        val user = txtCL
                        editor.putString(mApp.PREF_USER, user.text.toString())
                        editor.commit()
                        val inte= Intent(this,testListCL::class.java)
                        startActivity(inte)
                        finish()



                    }
                    else{
                        Toast.makeText(this@Main3ActivityCLDatos, "Errozr", Toast.LENGTH_LONG).show()
                    }
                    //....

                } catch (e: JSONException) {
                    Toast.makeText(this@Main3ActivityCLDatos, "Errorx ", Toast.LENGTH_LONG).show()
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




}
