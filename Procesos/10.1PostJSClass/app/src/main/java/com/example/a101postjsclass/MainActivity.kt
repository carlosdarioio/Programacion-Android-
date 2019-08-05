package com.example.a101postjsclass

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
import java.io.File
import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest


//Post solo para verificar el envio de kotlin al servicio

//si funcioa proframar completo el kt para crear entrega
//poniendo los datos en el texview pa no matarse con esos adapter__mientras le agarras a los adapters
class MainActivity : AppCompatActivity() {
    private var queue: RequestQueue? = null

    //Json4Kotlin_Base xJson4Kotlin_Base=new Json4Kotlin_Base();
//val users: List<User> = listOf( User("Tom", 32), User("John", 64) ) !!!

    //asignando valores manual mente para mandar el post de un solo
    //creamdo propiedades de Base
    var testlist= Posttest("10","001810")
    var listposttest:List<Posttest> = mutableListOf(testlist,Posttest("5","002010"))

    //creando base
    var Base=Json4Kotlin_Base(360010,"PosteandoTest",listposttest,0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAgregarCodigo.setOnClickListener{

            //intentar convertir clase a bite
            var gson = Gson()
            var xBase=gson.toJson(Base)




            val md5 = MessageDigest.getInstance("MD5")
            //val hash = BigInteger(1, md5.digest(xBase.toByteArray(Charset.defaultCharset()))).toString(16)
            val hash = BigInteger((xBase.toByteArray()))
             //xtextView.text=hash.toString()//texto en clave
            //xtextView.text=String(hash.toByteArray())//desbloqueando texto en clave




            //val path = "favicon.ico" // already downloaded to current directory
            val bytes =xBase.toByteArray()// File(path).readBytes()
            val base64 = Base64.encodeToString(bytes,1)


            editText2.setText(base64)
            xtextView.text=base64//texto en clave


            //Base.posttest=Base.posttest+Posttest(txtcantidad.text.toString(),txtcodigo.text.toString())
        }

        //enviar datos volley
        btnCerrar.setOnClickListener{
            Toast.makeText(this@MainActivity, "press this2", Toast.LENGTH_LONG).show()
            obtenerDatosVolley()
        }




    }

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
        var jsonString = gson.toJson(Base)
        val jsonObject = JSONObject(jsonString)

        val request = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                try {


                    val mJSONArray = response.getJSONArray("Posttest")
                    val mJSONObject = mJSONArray.getJSONObject(0)


                    val name1 = response.getString("message")
                    var name2 = mJSONObject.getString("status")
                    //OPCION DIRECTA
                    //val name2 = response.getJSONArray("users").getJSONObject(0).getString("nombre")


                    //un reusltado
                    //val name = response.getString("title")


                    val topic = Gson().fromJson(response.toString(), Json4Kotlin_Base::class.java  )

                    name2 = topic.posttest[1].item

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

}//Fin Mainactiviy
