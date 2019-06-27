package com.example.myappkotlin.Models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myappkotlin.R
import java.util.ArrayList
;

class UserListAdapter(private val context: Context, private val dataModelArrayList: ArrayList<UserModel>) :
    BaseAdapter() {

    override fun getViewTypeCount(): Int {
        return count
    }

    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun getCount(): Int {
        return dataModelArrayList.size
    }

    override fun getItem(position: Int): Any {
        return dataModelArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.lv_player, null, true)


            holder.id = convertView!!.findViewById(R.id.id) as TextView
            holder.nombre = convertView.findViewById(R.id.nombre) as TextView
            holder.estado = convertView.findViewById(R.id.estado) as TextView

            convertView.tag = holder
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = convertView.tag as ViewHolder
        }


        holder.id!!.text = "id: " + dataModelArrayList[position].getid()
        holder.nombre!!.text = "nombre: " + dataModelArrayList[position].getNombre()
        holder.estado!!.text = "estado: " + dataModelArrayList[position].getestado()

        return convertView
    }

    private inner class ViewHolder {

        var id: TextView? = null
        var nombre: TextView? = null
        var estado: TextView? = null

    }

}