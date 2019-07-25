package com.example.cftranspendtxalmacen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_view_transfx_alm.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class ViewTransfxAlm : AppCompatActivity() {
//visualizando vista del almacen muestro
private lateinit var animal:Users
private lateinit var WTQ1:List<Users2>
private lateinit var users2 : JSonBase
    var alola=""




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_transfx_alm)


    if(intent !=null) {
        animal=intent.extras.getSerializable("xuser") as Users

        doAsync {
            //obtendiendo json local en casa
            //var response= URL("http://acefemosa.com/js/025.json").readText()
            //usar este en el work
            val response = URL("http://10.1.0.136/CFService/SapService.svc/getWTQ1XDocnum/" + animal.Transf).readText()
            //pasando json a clase son Gson
            //WTQ1 = Gson().fromJson(response, WTQ1::class.java)
            uiThread {
                //Pasando var animals
                //setUpRecyclerView(animals)
               // WTQ1 = users2.users2
                alola=response
                txtdatos.text=alola

            }


        }//fin doasync
    }


    initToolbar()
    initView()
//idea pone dentro del initView una opcion que recoba la Transf in obtenga un gson que le de los articulos de esa trans
    }

    private fun initView(){
        textDescription.text=animal.Transf
        textDE.text=animal.A
        textEstado.text=animal.Estado
        textUsuario.text=animal.Usuario
        //imageDetail.loadUrl("https://www.femosa.hn/content/images/thumbs/0002063.png")
    }

    private fun initToolbar(){
        //setSupportActionBar(toolbar)
        supportActionBar?.title=animal.Estado
        supportActionBar?.setDisplayHomeAsUpEnabled(true)//estab atrue eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
    }

    /*
    fun ImageView.loadUrl(url:String)
    {
        Picasso.get().load(url).into(this)
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            android.R.id.home ->{
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }



}
