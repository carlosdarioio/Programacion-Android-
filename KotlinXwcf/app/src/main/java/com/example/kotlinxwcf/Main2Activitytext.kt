package com.example.kotlinxwcf

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinxwcf.model.classUser
import kotlinx.android.synthetic.main.activity_main2_activitytext.*

class Main2Activitytext : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_activitytext)
        var people = intent.getSerializableExtra("putuser") as? classUser
        btngettxt.setOnClickListener {
            Toast.makeText(applicationContext,"tiene ${people?.ProductId}", Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext,"tiene ${MainActivity().ztext}", Toast.LENGTH_SHORT).show()
        }

        btnchangetxt.setOnClickListener{
            //MainActivity().ztext="activity_main2_activitytext"
            people?.ProductId=2
        }

        btnopenclas1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("putuser",people)
            startActivity(intent)
            finish();
        }

        btnopenclas3.setOnClickListener {
            val intent = Intent(this, Main3Activitytext::class.java)
            intent.putExtra("putuser",people)
            startActivity(intent)
            finish();
        }
    }//Fin Oncreate


}

