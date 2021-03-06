package com.example.listadeanimales

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.uiThread
import java.io.Serializable
import java.net.URL
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.view.Menu
import android.widget.ImageView




class MainActivity : AppCompatActivity() {

    companion object{
        val EXTRA_ANIMAL:String="EXTRA_ANIMAL"
    }

    private lateinit var animalsAdapter:AnimalsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        getDataFromApi()
    }

    //toolbar tab
    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title=getString(R.string.app_name)
    }

    //Get json Data from api
    private fun getDataFromApi(){

        doAsync {            //Obtendiendo json
            val response= URL("https://cursokotlin.com/jsonservices/animals.json").readText()            //pasando json a clase son Gson
            val animals:AnimalsList=Gson().fromJson(response,AnimalsList::class.java)
            uiThread {
                //Pasando var animals
                setUpRecyclerView(animals)
            }
        }
    }//fin getDataFromApi


    //setUpRecyclerView
    private  fun setUpRecyclerView(animals: AnimalsList){
        animalsAdapter=AnimalsAdapter(animals,{animal,image->openAnimalDetail(animal,image)})
        rvAnimals.setHasFixedSize(true)
        rvAnimals.layoutManager=LinearLayoutManager(this)
        rvAnimals.adapter=animalsAdapter
    }

    /*
    fun ImageView.loadUrl(url:String)
    {
        Picasso.get().load(url).into(this)
    }
*/
    //openAnimalDetail
    fun openAnimalDetail(animal:Animal,image:ImageView){
val options=ActivityOptionsCompat.makeSceneTransitionAnimation(this,image,"imageDefault")
        //intentforR!!!!!!!!!!!!!!!!!!!!!!!
        startActivity(intentFor<AnimalDetailActivity>(EXTRA_ANIMAL to animal as Serializable),options.toBundle())
    }


}
