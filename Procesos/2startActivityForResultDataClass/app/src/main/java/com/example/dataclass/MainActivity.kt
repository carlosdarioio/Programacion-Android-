package com.example.dataclass

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val xfname=fname
        val xsname=sname
        val xage=age


        btnDisplay.setOnClickListener {
val person:Person=Person(xfname.text.toString(),xsname.text.toString(),
                            age.text.toString().toInt(), Date())


            val intent= Intent(this,PersonDisplayActivity::class.java)
            intent.putExtra("person",person)
            intent.putExtra("somekey",10)

            startActivityForResult(intent,12)



        }//fin button setonclick listener
    }//fin on create

    //control o para ver acciones que haces
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)



            if(resultCode==Activity.RESULT_OK){
                //do something with the data

                if(data!=null) {
                    //obtendiendo respuesta
                    val returnedPerson: Person = data.getSerializableExtra("return_person") as Person
                    Log.d("EA", returnedPerson.toString())
                }
            }
            else if(resultCode==Activity.RESULT_CANCELED){
                //ignore and do something else
                Log.d("EA","User canceled")
            }

    }
}
