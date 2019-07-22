package com.example.cftranspendtxalmacen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.card_animal.view.*

//pagina 253
class AnimalsAdapter (val xJSonBase: JSonBase,val onClickAnimal:(Users, TextView)->Unit) : RecyclerView.Adapter<AnimalsAdapter.ViewHolder>()
{
    override fun onBindViewHolder(holder: ViewHolder, position:Int){
        val item=xJSonBase.users[position]
        holder.bind(item,onClickAnimal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):ViewHolder{
        val layoutInflater= LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.card_animal,parent,false))
    }

    override fun getItemCount(): Int {
        return xJSonBase.users.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)        {
         //Animal es Users
        fun bind(xUsers:Users,onClickAnimal: (Users, TextView) -> Unit)
        {
            itemView.setOnClickListener{onClickAnimal(xUsers,itemView.textName)}
            itemView.textName.text=xUsers.A+"-"+xUsers.Transf
        }

        /*
        private fun ImageView.loadUrl(url:String)
        {
            Picasso.get().load(url).into(this)
        }*/


    }






}//fin line 8
