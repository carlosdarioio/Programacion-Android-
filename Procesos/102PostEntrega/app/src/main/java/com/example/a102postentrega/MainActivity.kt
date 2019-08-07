package com.example.a102postentrega

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest

class MainActivity : AppCompatActivity() {
    private var queue: RequestQueue? = null

    //creamdo propiedades de Base
    var xEntrega= postEntrega("10","001810","44","42")
    var listEntrega:List<postEntrega> = mutableListOf(xEntrega,postEntrega("cription","002010","4","4"))

    //creando base
    var BaseEntrega=GetEntregaResult("xcardName","xcardcode","docentry","docnum",listEntrega,"xmessage","xtatus")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAgregar.setOnClickListener{

            //intentar convertir clase a bite
            var gson = Gson()
            var xBaseEntrega=gson.toJson(BaseEntrega)

            //val hash = BigInteger(1, md5.digest(xBase.toByteArray(Charset.defaultCharset()))).toString(16)
            val hash = BigInteger((xBaseEntrega.toByteArray()))
            //xtextView.text=hash.toString()//texto en clave
            //xtextView.text=String(hash.toByteArray())//desbloqueando texto en clave




            //val path = "favicon.ico" // already downloaded to current directory
            val bytes =xBaseEntrega.toByteArray()// File(path).readBytes()
            val base64 = Base64.encodeToString(bytes,Base64.DEFAULT)//val output = Base64.encodeToString(data, Base64.DEFAULT)


            editText2.setText(base64)
            xtextView.text=base64//texto en clave


            //Base.posttest=Base.posttest+Posttest(txtcantidad.text.toString(),txtcodigo.text.toString())
        }

        //enviar datos volley
        btnCerrar.setOnClickListener{
            Toast.makeText(this@MainActivity, "press this2", Toast.LENGTH_LONG).show()
            obtenerDatosVolley()
        }

    }//fin oncreate


    //------------------------------------------------------------------------------------
    //inicio string to md5
    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }//fins string ot md5

    private fun obtenerDatosVolley() {
        //20190610 obtendiendo datos desde los https funciona
        //String url="https://api.androidhive.info/contacts/";
        //String url="http://jsonplaceholder.typicode.com/todos/1";
        val url="http://10.1.0.136/HouseService.svc/ListPostTest"//varios resulados
        //val url = "http://10.1.0.136/CFService/Service1.svc/GetData2/xr"//un resultados
        var gson = Gson()
        var jsonString = gson.toJson(BaseEntrega)
        val jsonObject = JSONObject(jsonString)

        val request = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                try {


                    val topic = Gson().fromJson(response.toString(), GetEntregaResult::class.java  )
                    val mJSONArray = response.getJSONArray("Posttest")
                    val mJSONObject = mJSONArray.getJSONObject(0)


                    val name1 = topic.message
                    val name2 = topic.postEntrega[0].itemCode

                    xtextView.setText("mesaage: $name1 nombre: $name2")
                    Toast.makeText(this@MainActivity, "Nombre:$name1 Nombre2:$name2", Toast.LENGTH_LONG).show()


                } catch (e: JSONException) {
                    xtextView.setText("error2")
                    e.printStackTrace()
                }
            }, Response.ErrorListener { xtextView.setText("error3") })

        queue?.add(request)

    }//Fin obtener Datos Volley

    //-------------------------------------------------------------------------------------

}//fin mainactivity
