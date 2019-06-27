package com.example.myappkotlin

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_test_list_cl.*
import kotlinx.android.synthetic.main.row_main.view.*

class testListCL : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_list_cl)

        var listView=main_listview

        listView.adapter= MyCustomAdapter(this) //--pendiente


    }//fin onccreate


    //inicio class MyCustomAdapter
    private class MyCustomAdapter(context: Context):BaseAdapter(){

        private val mContext:Context

        private val names= arrayListOf<String>(
            //por aqui vas pendiente
            //entra aqui solo si la busqueda de cl es mas de uno
            //pasar el cl que ingreso pa buscar cl y lista json
            "mAGENMITE","sALAMANCE","Eevve"
        )

        init
        {
            mContext=context
        }


        //responsible for how many rows in my list
        override fun getCount(): Int {

            return names.size

        }//fin getCount

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }//fin getItemId

        override fun getItem(position: Int): Any {
            return "alola"
        }//fin getItem

        //responsible for rendering out eatch row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            //val textView= TextView(mContext)
            //textView.text="Here is my row form my ListView"
            //return  textView

            val layoutInflater=LayoutInflater.from(mContext)
            val rowMain=layoutInflater.inflate(R.layout.row_main,viewGroup,false)

            val nameTextView=rowMain.name_textview
            nameTextView.text=names.get(position)

            val positionTextView=rowMain.position_textview
            positionTextView.text="Row Number $position"

            return rowMain



        }
    }//fin class MyCustomAdapter




}
