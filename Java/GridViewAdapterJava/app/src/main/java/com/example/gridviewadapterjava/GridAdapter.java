package com.example.gridviewadapterjava;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> arrayList;
public GridAdapter (Context context, ArrayList<String> arrayList)
{
    //asignando
this.context=context;
this.arrayList=arrayList;

}

    @Override
    public int getCount() {
    //tamaños
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
    //obtener array x position
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
    //pasar posicion
    return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    if(convertView==null)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.item_grid,null);
    }
    //asignando valot al ig_tv_titulo del layout item_grid
        TextView tituloTv=(TextView) convertView.findViewById(R.id.ig_tv_titulo);
        tituloTv.setText(arrayList.get(position));


//importante si no lo retornas falla osea
        return convertView;
    }
}
