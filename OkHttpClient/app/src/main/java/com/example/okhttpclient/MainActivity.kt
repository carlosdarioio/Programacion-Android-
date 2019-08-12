package com.example.okhttpclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.Charset
import com.google.gson.JsonObject
import com.google.gson.JsonArray



class MainActivity : AppCompatActivity() {
/*
* NOTAS
*Te ayudo bastante ocn el uso del post volley: https://www.youtube.com/watch?v=mJYwYc51IKI
* */
    var testlist= Array2("cala")
    var listposttest:List<Array2> = mutableListOf(testlist,Array2("cnmon"))

    var xBase:Json4Kotlin_Base=Json4Kotlin_Base(listposttest,"aa")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnget.setOnClickListener {
            getval()
        }

        btnpost.setOnClickListener {
            postval()
        }

    //post only text Funciona!
    btntest1.setOnClickListener {
            posttest1()
        }

    //post text and list
    btntest2.setOnClickListener {
        posttest2()
    }

    }//Fin Oncreate


    //inicio fun getval
    fun getval() {
        Toast.makeText(this, "Presiono btnget", Toast.LENGTH_SHORT).show()
        //-------------------------------------------------------

        doAsync {
        //val url = "http://10.1.0.136:81/SapService.svc/xGetData/lalala"//trabajo
        val xurl="http://192.168.0.17:80/CFService/SapService.svc/xGetData/alola"//Casa
        val apiResponse = URL(xurl).readText()
        Respuesta.text="poder "+apiResponse
        //val animals:JSonBase= Gson().fromJson(apiResponse,JSonBase::class.java)
            uiThread {
                //Pasando var animals
                //setUpRecyclerView(animals)
                //Respuesta.text="poder "+apiResponse
            }
        }
        //-------------------------------------------------------
    }//fin fun getval

    //inicio postval----------------------------------------------------------------------
    fun postval() {
        //https://android--code.blogspot.com/2019/02/android-kotlin-volley-post-request-with.html
        //val url = "http://10.1.0.136:81/SapService.svc/xPostvalue"//trabajo
        val url="http://192.168.0.17:80/CFService/SapService.svc/xPostvalue"//Casa

        Toast.makeText(this, "Presiono btnpost", Toast.LENGTH_SHORT).show()

        //---------------

        // Post parameters
        // Form fields and values
        val params = HashMap<String,String>()
        params["value"] = "0"
        val jsonObject = JSONObject(params)


        // Volley post request with parameters
        val request = JsonObjectRequest(
            Request.Method.POST,url,jsonObject,
            Listener { response ->
                // Process the json
                //try {
                    Respuesta.text = "ZZResponse: $response"
                println( "ZZResponse: $response")
                //}catch (e:Exception){
                  //  Respuesta.text = "EEException: $e"
                //}

            }, Response.ErrorListener{
                // Error in request
                Respuesta.text = "Volley error: $it"
                println("Volley error: $it")
            })

        Respuesta.text = "R: ${request}"
        println("R: ${request.body}")

        val queue = Volley.newRequestQueue(this)



// Add the request to the RequestQueue.
        // Add the volley post request to the request queue
        // ----------------
    }//fin gunpostval
    //-----------------------------------------------------------------------------------

    //test1 post-----------------------------------------------
    fun posttest1()
    {
        println("jsonObjectRequestPost")

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)

        val url = "http://192.168.0.17:80/CFService/SapService.svc/testpost1"


        val xRootObject = JSONObject()//jsonObject
        xRootObject.put("value", editTexttxt.text)//editTexttxt

        // Request a JSONObject response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(url, xRootObject,
            Response.Listener { response ->
                println("Response is: $response")
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
                println( "That didn't work!")
            }
        )

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }
    //fin test1 post-------------------------------------------

    //test2 post list/array -----------------------------------------------
    fun posttest2()
    {
        println("jsonObjectRequestPost")

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.17:80/CFService/SapService.svc/testpost2"

        val array2 = JsonArray()
        array2.add("aaa")
        array2.add("bbb")
        val object2 = JsonObject()
        object2.add("xarray", array2)

        val xRootObject2 = JSONObject()//jsonObject
        xRootObject2.put("value2", editTexttxt.text)//editTexttxt
        xRootObject2.put("xarray2", object2)

        // Request a JSONObject response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(url, xRootObject2,
            Response.Listener { response ->
                println("posttest2 is: $response")
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
                println( "xThat didn't work!")
            }
        )

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }
    //fin test2 post-------------------------------------------

}
