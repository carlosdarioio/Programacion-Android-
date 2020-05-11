package com.example.kotlinxwcf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlinxwcf.model.classUser
import com.example.kotlinxwcf.model.xData
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.activity_main2_activitytext.*

class MainActivity : AppCompatActivity() {
//test a aser:
//crera variable sin pasarla mostrarla y modificarla desde otras 2 clases,actualizar texto con new val
//crear clase y aser lo mismo
//crear clase recibir json y aser lo mismo

    var ztext="activity_main"
    var xUser=classUser("",0)

    var gson = Gson()

var datalist=xData(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("1text",ztext)
        xUser.name="inicio"
        xUser.age=1
        //x aqui vas mutable list siempre sale null
        //ver https://stackoverflow.com/questions/33278869/how-do-i-initialize-kotlins-mutablelist-to-empty-mutablelist
        datalist.lista?.add(0,xUser)
        /*Pendiente comprobar si no recibe solo esta clase ya que es la que inicia*/
         val bundle=intent.extras
         if(bundle!=null)
            {
                xUser = intent.getSerializableExtra("putuser") as classUser
            }

        btngettextval.setOnClickListener{
            Toast.makeText(applicationContext,"tiene ${xUser.name}",Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext,"tiene $ztext",Toast.LENGTH_SHORT).show()
        }

        btnchanlocal.setOnClickListener{
            xUser.name="Main1text"
        }

        btn1openclass.setOnClickListener {
            val intent = Intent(this, Main2Activitytext::class.java)
            intent.putExtra("putuser",xUser)
            startActivity(intent)
            finish();
        }

        btn1openclass3.setOnClickListener{
            val intent = Intent(this, Main3Activitytext::class.java)
            intent.putExtra("putuser",xUser)
            startActivity(intent)
            finish();
        }

        //test pasando class to json
        btngetjsonclass.setOnClickListener {
            datalist.lista?.add(xUser)
            //var jsonString: String = gson.toJson(xUser)//funciona!
            var jsonString: String = gson.toJson(datalist)
            Toast.makeText(applicationContext,"tiene $jsonString",Toast.LENGTH_SHORT).show()
        }
        btntojson.setOnClickListener {
            Toast.makeText(applicationContext,"tiene ${datalist.lista?.get(0)?.name}",Toast.LENGTH_SHORT).show()
        }




    }
}
