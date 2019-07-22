package com.example.cftranspendtxalmacen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_view_transfx_alm.*

class ViewTransfxAlm : AppCompatActivity() {
//visualizando vista del almacen muestro
private lateinit var animal:Users

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_transfx_alm)
    if(intent !=null) {
        animal=intent.extras.getSerializable("xuser") as Users
    }
    initToolbar()
    initView()

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
