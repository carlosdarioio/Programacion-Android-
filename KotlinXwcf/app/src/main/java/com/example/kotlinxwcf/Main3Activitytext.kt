package com.example.kotlinxwcf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinxwcf.model.classUser

import kotlinx.android.synthetic.main.activity_main3_activitytext.*

class Main3Activitytext : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3_activitytext)
        var people = intent.getSerializableExtra("putuser") as? classUser

        btngettext.setOnClickListener {
            Toast.makeText(applicationContext,"tiene ${people?.name}", Toast.LENGTH_SHORT).show()
        }

        btnchangetext.setOnClickListener {
            people?.name="Main3text"
        }

        btnopenclass1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("putuser",people)
            startActivity(intent)
            finish();
        }
        btnopenclas2.setOnClickListener {
            val intent = Intent(this, Main2Activitytext::class.java)
            intent.putExtra("putuser",people)
            startActivity(intent)
            finish();
        }

    }
}
