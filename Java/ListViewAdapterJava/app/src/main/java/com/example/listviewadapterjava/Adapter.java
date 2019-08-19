package com.example.listviewadapterjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<MDuvatec> arrayList;
    //creando construcctor de adapter
    public Adapter(Context context, ArrayList<MDuvatec> arrayList){
this.context=context;
this.arrayList=arrayList;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.item,null);

        }

        TextView nombre = (TextView)convertView.findViewById(R.id.i_tv_nombre);
        TextView descripcion = (TextView)convertView.findViewById(R.id.i_tv_descripcion);

        //asignando valores
        nombre.setText(arrayList.get(position).getNombre());
        descripcion.setText(arrayList.get(position).getDescripcion());


        return convertView;
    }
}
