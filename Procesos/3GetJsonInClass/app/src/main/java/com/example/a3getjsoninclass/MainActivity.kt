package com.example.a3getjsoninclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.a3getjsoninclass.DATA.Lusers
import com.example.a3getjsoninclass.DATA.users
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    private var queue: RequestQueue? = null
    //val xusers:users

    var xlist: List<Lusers>?=null
    var xusers:users=users("","",xlist
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        queue = Volley.newRequestQueue(this)


        btn.setOnClickListener{
            obtenerDatosVolley()
        }


    }//Fin OnCreate

    //------------------------------------------------------------------------------------
    private fun obtenerDatosVolley() {
        //20190610 obtendiendo datos desde los https funciona
        //String url="https://api.androidhive.info/contacts/";
        //String url="http://jsonplaceholder.typicode.com/todos/1";
        val url="http://10.1.0.136/CFService/Service1.svc/Getusers/"//varios resulados
        //val url = "http://10.1.0.136/CFService/Service1.svc/GetData2/xr"//un resultados

        val request = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                try {
                    //por aqui vas intentando asignar valores al model con un for despues pasarlo por staertactivity
                    //varios resultados
                    val mJSONArray = response.getJSONArray("users")
                    val mJSONObject = mJSONArray.getJSONObject(0)

                    //PROBA ASIGNARLE VALORES A LA CLASE
                    val name1 = response.getString("message")
                    val name2 = mJSONObject.getString("nombre")
                    //OPCION DIRECTA
                    //val name2 = response.getJSONArray("users").getJSONObject(0).getString("nombre")


                    //un reusltado
                    //val name = response.getString("title")

                    /*
                    var str_user: String = ""
                    for (i in 0 until mJSONArray.length()) {
                        var jsonInner: JSONObject = mJSONArray.getJSONObject(i)
                        str_user = str_user + "\n" + jsonInner.get("login")
                    }*/


                    txt.setText("mesaage: $name1 nombre: $name2")
                    Toast.makeText(this@MainActivity, "Nombre:$name1 Nombre2:$name2", Toast.LENGTH_LONG).show()


                } catch (e: JSONException) {
                    txt.setText("error2")
                    e.printStackTrace()
                }
            }, Response.ErrorListener { txt.setText("error3") })

        queue?.add(request)

    }//Fin obtener Datos Volley

    //-------------------------------------------------------------------------------------


}//Fin MainActivity
