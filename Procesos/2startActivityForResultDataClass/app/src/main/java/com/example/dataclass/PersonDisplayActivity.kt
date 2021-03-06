package com.example.dataclass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_person_display.*
import kotlinx.android.synthetic.main.content_person_display.*

class PersonDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_display)
        setSupportActionBar(toolbar)

        val person:Person = intent.getSerializableExtra("person") as Person
        val someValue:Int=intent.getIntExtra("somekey",999)

        val xfname=fname
        val xsname= sname
        val xsage=age

        xfname.text=person.fname
        xsname.text=person.sname
        xsage.text=person.age.toString()




        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        val sbutton=save
        val cbutton=cancel


        sbutton.setOnClickListener{

            val newPerson:Person=Person("fisrt name has best change","last name too",10)
            val returnIntent:Intent=Intent()
            returnIntent.putExtra("return_person",newPerson)
            returnIntent.putExtra("some_new_value",55)

            setResult(Activity.RESULT_OK,returnIntent)
            //person.fname="cambiado desde alola"
            //person.sname="this have change too"
            finish()
        }

        cbutton.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }





    }

}
