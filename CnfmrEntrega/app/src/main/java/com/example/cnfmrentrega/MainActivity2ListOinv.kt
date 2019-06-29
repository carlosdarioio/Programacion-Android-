package com.example.cnfmrentrega

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_activity2_list_oinv.*
import kotlinx.android.synthetic.main.row_main_listcl.view.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity2ListOinv : AppCompatActivity() {
    var mApp = GlobalsVar()
    var getextra=""
    private var URLstring = "http://10.1.0.136/CFService/SapService.svc/FindFactura/1"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2_list_oinv)

        //lista de reusltado
        var listView=main_listview

        ///adaptador asignando al listView la funcion MyCustomAdapter
        listView.adapter= MyCustomAdapter(this) //--pendiente


        ////obtendiendo valor de factura a buscar
        getextra=intent.getStringExtra("factura")
        Toast.makeText(this@MainActivity2ListOinv, "Obteniendo: $getextra", Toast.LENGTH_LONG).show()




        //-----------------------------------
        var txtxl=getextra
        Toast.makeText(this@MainActivity2ListOinv, "entra ", Toast.LENGTH_LONG).show()
        val stringRequest = StringRequest(
            //asignando valores falta poner el del user que entra
            Request.Method.GET, URLstring+txtxl+"/Venta07",
            Response.Listener { response ->
                Log.d("strrrrr", ">>$response")
                try {



                    //obteniendo status para verificar estado de la busqueda


                    //por aqyu vas asignar mJSONArray al array  names
                    val xresponse = JSONObject(response)
                    val mJSONArray = xresponse.getJSONArray("users")//nombre de objec json
                    val mJSONObject = mJSONArray.getJSONObject(2)
                    val name = mJSONObject.getString("name")
                    Toast.makeText(this@MainActivity2ListOinv, "Nombre:$name", Toast.LENGTH_LONG).show()


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





                } catch (e: JSONException) {
                    Toast.makeText(this@MainActivity2ListOinv, "Errorx ", Toast.LENGTH_LONG).show()
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
        //-------------------------------------



    }//fin oncrteate

    //inicio class MyCustomAdapter ___ alola funciona para añadir valor al main_listview__lista donde irian la busqueda
    private class MyCustomAdapter(context: Context): BaseAdapter(){

        private val mContext: Context

        //2019 06 27__por aqui vas
        //con el hetExtra listar los datos de las facturas encontradas
        // y ver pasarlas a la lista

        //2019 06 28
        //var tiene el docentry de fatura obtene el json array y poner en el arrayListOf



        private val names= arrayListOf<String>(

            "mAGENMITE","sALAMANCE","Eevve","zangoose", "oohh yea"
        )

        init
        {
            mContext=context
        }


        //responsible for how many rows in my list
        override fun getCount(): Int {

            return names.size

        }//fin getCount

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }//fin getItemId

        override fun getItem(position: Int): Any {
            return "alola"
        }//fin getItem

        //responsible for rendering out eatch row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            //val textView= TextView(mContext)
            //textView.text="Here is my row form my ListView"
            //return  textView

            val layoutInflater= LayoutInflater.from(mContext)
            //asignando layout externo
            val rowMain=layoutInflater.inflate(R.layout.row_main_listcl,viewGroup,false)

            //cambiando TextView de layout externo
            val nameTextView=rowMain.name_textview
            nameTextView.text=names.get(position)

            val positionTextView=rowMain.position_textview
            positionTextView.text="Row Number $position"

            return rowMain



        }
    }//fin class MyCustomAdapter





}//fin class
