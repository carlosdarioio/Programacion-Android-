package com.example.cftranspendtxalmacen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_transfx_alm.*
import org.jetbrains.anko.intentFor
import java.io.Serializable


class TransfxAlm : AppCompatActivity() {
//cargando lista de transferencia del almacen puesto
    var almacen=""
    var test="nop"
    private lateinit var animalsAdapter:AnimalsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfx_alm)

    if(intent !=null)
    {
        //Obtendiendo intent extras
        almacen=intent.extras.getString("xalmacen")
        Toast.makeText(this, "Almacen Ingresado:  "+almacen, Toast.LENGTH_SHORT).show()
        initToolbar()
        getDataFromApi()
    }
    }//Fin Oncreate

    //toolbar tab asignando titulo
    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title=getString(R.string.app_name)
    }

    //Get json Data from api _comproba que Cantidaden json no lleve,00
    private fun getDataFromApi(){
        //Obteniendo y pasando a Model
        doAsync {
            //obtendiendo json local en casa
            //var response= URL("http://acefemosa.com/js/025.json").readText()
            //usar este en el work
            val response= URL("http://10.1.0.136/CFService/SapService.svc/getTransXAlmacen/"+almacen).readText()
            //pasando json a clase son Gson
            val xJSonBase:JSonBase= Gson().fromJson(response,JSonBase::class.java)
            uiThread {
                //Pasando var animals
                //setUpRecyclerView(animals)
                setUpRecyclerView(xJSonBase)
            }
        }
    }//fin getDataFromApi

    //setUpRecyclerView
    private  fun setUpRecyclerView(xJSonBase:JSonBase){

    animalsAdapter=AnimalsAdapter(xJSonBase,{User,textview->openAnimalDetail(User,textview)})
    //rvAnimals es el RecyclerView
    rvAnimals.setHasFixedSize(true)
    rvAnimals.layoutManager= LinearLayoutManager(this)
    rvAnimals.adapter=animalsAdapter




    }//fin setUpRecyclerView

    //animals es JSonBase
    //animal es User
    //AnimalDetailActivity es ViewTransfxAlm
    //openAnimalDetail   animal:Animal
    fun openAnimalDetail(trans:Users,textview:TextView){
        val options= ActivityOptionsCompat.makeSceneTransitionAnimation(this,textview,"imageDefault")
        //intentforR!!!!!!!!!!!!!!!!!!!!!!!
        startActivity(intentFor<ViewTransfxAlm>("xuser" to trans as Serializable),options.toBundle())
    }//fin openAnimalDetail






    //onBackPressed
    override fun onBackPressed() {
        //do whatever you want the 'Back' button to do
        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'
        this.startActivity(Intent(this, MainActivity::class.java))
        finish()
        return
    }// fin onBackPressed
}//fin all
