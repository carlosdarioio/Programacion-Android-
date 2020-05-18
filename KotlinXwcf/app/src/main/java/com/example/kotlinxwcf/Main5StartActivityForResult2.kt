package com.example.kotlinxwcf

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinxwcf.model.classUser
import kotlinx.android.synthetic.main.activity_main5_start_for_result2.*

class Main5StartActivityForResult2 : AppCompatActivity() {
    var people=classUser("",0)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5_start_for_result2)
        people = intent.getSerializableExtra("putuser") as classUser
        editText.setText(people.name+people.age.toString())

        //cambiar
        button.setOnClickListener {
            people.age=people.age+1
            people.name="Main5StartActivityForResul2"
            val result = Intent()
            result.putExtra("putuser", people)
            setResult(Activity.RESULT_OK, result)
            finish()
        }
        //cancrlar
        button2.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        //start Activity 6
        button3.setOnClickListener {
            val intent = Intent(this, Main6StartActivityForResult::class.java)
            intent.putExtra("putuser",people)
            startActivityForResult(intent,5 )
        }
    }//Fin OnCreate
    //Recibiendo ActivityForResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Check that it is the SecondActivity with an OK result
        if (requestCode == 5) {
            if (resultCode == Activity.RESULT_OK) {
                val returnString = data!!.getSerializableExtra("putuser") as classUser
                people=returnString
                editText.setText(people.name+people.age.toString())
                Log.d("Nwuser",people.name)
                Log.d("Nage",people.age.toString())
            }else if(resultCode == Activity.RESULT_CANCELED)
            {
                Log.d("cancel","canzelado")
            }
        }
    }
    //Fin Recibidendo
}//Fin All
