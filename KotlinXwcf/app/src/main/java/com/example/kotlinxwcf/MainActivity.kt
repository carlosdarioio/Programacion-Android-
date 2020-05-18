package com.example.kotlinxwcf

import android.app.Activity
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
var xUser3=classUser("",0)
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



        //Test Pasando y resiviendo datos por medio de Start Activity For Result
        btnstartForr1.setOnClickListener {
            val intent = Intent(this, Main4StartActivityForResult::class.java)
            intent.putExtra("putuser",xUser)
            startActivityForResult(intent,4 )
        }

        btnstartForr2.setOnClickListener {
            val intent = Intent(this, Main5StartActivityForResult2::class.java)
            intent.putExtra("putuser",xUser)
            startActivityForResult(intent,4 )
        }

        btnstartForr3.setOnClickListener {
            val intent = Intent(this, Main6StartActivityForResult::class.java)
            intent.putExtra("putuser",xUser)
            startActivityForResult(intent,4 )
        }




    }//Fin Oncreate

    //Recibiendo ActivityForResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Check that it is the SecondActivity with an OK result
        if (requestCode == 4) {
            if (resultCode == Activity.RESULT_OK) {
                val returnString = data!!.getSerializableExtra("putuser") as classUser
                xUser=returnString
                textView.setText(xUser.name+xUser.age.toString())
                Log.d("Nwuser",xUser.name)
                Log.d("Nage",xUser.age.toString())
            }else if(resultCode == Activity.RESULT_CANCELED)
            {
                Log.d("cancel","canzelado")
            }
        }
    }
    //Fin Recibidendo

}
