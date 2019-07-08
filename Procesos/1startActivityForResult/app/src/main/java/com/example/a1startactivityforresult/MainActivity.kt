package com.example.a1startactivityforresult

import android.app.Activity
import android.app.DownloadManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//este lo isiste simple

    //est ees el mismo pero con model
    //https://www.youtube.com/watch?v=S1isQRnYAF4&list=PLP8n25bNfkdfq22qm_v_eYI8ZyYR98Ra3&index=9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnsumar.setOnClickListener {
            val xnum1=num1.text.toString()
            val xnum2=num2.text.toString()

            val intent:Intent= Intent(this,suma::class.java)

            intent.putExtra("num1",xnum1)
            intent.putExtra("num2",xnum2)

            startActivityForResult(intent,12)



        }







    }//fon oncreate

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode==Activity.RESULT_OK)
            {
                val returned=data!!.getStringExtra("returnsuma") as String

                result.text=returned
            }
        else if (resultCode==Activity.RESULT_CANCELED){
            result.text="cancel"
        }
    }
}
