package com.example.dataclass

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

            startActivity(intent)



        }
    }
}
