package com.example.kotlinxwcf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlinxwcf.model.classUser
import com.example.kotlinxwcf.model.xData
import com.example.kotlinxwcf.model.xData2
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.activity_main2_activitytext.*

class MainActivity : AppCompatActivity() {
//test a aser:
//crera variable sin pasarla mostrarla y modificarla desde otras 2 clases,actualizar texto con new val_ya
//crear clase y aser lo mismo_ya
//crear clase recibir json y aser lo mismo

    var ztext="activity_main"
    var xUser=classUser(0,0)

    var gson = Gson()
    var datalist=xData(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        xUser.ProductId=18
        xUser.Quantity=50

        Log.d("1text",ztext)
        datalist.StoreId="madreStoreId"
        datalist.CustomerId="qCustomerId"
        datalist.BillingAddressId="wwBillingAddressId"
        datalist.ShippingAddressId="ShippingAddressId"
        datalist.PickUpInStore="PickUpInStore"
        datalist.OrderTotal="OrderTotal"
        datalist.CardType="CardType"
        datalist.CardName="CardName"
        datalist.CardNumber="CardNumber"
        datalist.CardCvv2="CardCvv2"
        datalist.CardExpirationMonth="CardExpirationMonth"
        datalist.CardExpirationYear="CardExpirationYear"
        datalist.CustomOrderNumber="CustomOrderNumber"
        datalist.Email="Email"
        datalist.Catid="Catid"
        //añadiendo item
            datalist.OrderItem = arrayListOf()
            datalist.OrderItem?.add(xUser)
        //Fin añadiendo item


        /*Pendiente comprobar si no recibe solo esta clase ya que es la que inicia*/
         val bundle=intent.extras
         if(bundle!=null)
            {
                xUser = intent.getSerializableExtra("putuser") as classUser
            }

        btngettextval.setOnClickListener{
            Toast.makeText(applicationContext,"tiene ${xUser.ProductId.toString()}",Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext,"tiene $ztext",Toast.LENGTH_SHORT).show()
        }

        btnchanlocal.setOnClickListener{
            xUser.ProductId=1
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

        //conrtiendo json to string
        btngetjsonclass.setOnClickListener {
            xUser.ProductId=54
            xUser.Quantity=45
            datalist.OrderItem?.add(xUser)
            var jsonString1: String = gson.toJson(xUser)//funciona!
            var jsonString2: String = gson.toJson(datalist)
            madre.text=jsonString2
            Log.d("json ",jsonString1)
            Log.d("json ",jsonString2)
            Toast.makeText(applicationContext,"tiene $jsonString2",Toast.LENGTH_SHORT).show()
        }
        btntojson.setOnClickListener {
            //Toast.makeText(applicationContext,"tiene ${mutableList[0].name}",Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext,"tiene ${datalist}",Toast.LENGTH_SHORT).show()
        }
    //pasando json to another class
        btnopenc4.setOnClickListener {
            var NewUser=classUser(99,88)
            datalist.OrderItem?.add(NewUser)
            var jsonString2: String = gson.toJson(datalist)
            //madre.text=jsonString2
            Log.d("PutExtraJson ",jsonString2)
            val intent = Intent(this, Main4PutExtraJsonClass::class.java)
            intent.putExtra("putuser",jsonString2)
            startActivity(intent)
            finish();
        }



    }
}
