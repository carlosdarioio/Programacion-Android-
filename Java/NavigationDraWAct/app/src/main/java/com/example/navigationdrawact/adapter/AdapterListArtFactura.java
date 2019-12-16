package com.example.navigationdrawact.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.navigationdrawact.JsonClass.Articulo;
import com.example.navigationdrawact.R;


import java.util.ArrayList;

public class AdapterListArtFactura extends BaseAdapter{
    private Context context;
    private ArrayList<Articulo> arrayList;
    //creando construcctor de adapter
    public AdapterListArtFactura(Context context, ArrayList<Articulo> arrayList){
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
            //por auqi vas definiendo item1Art
            convertView=layoutInflater.inflate(R.layout.item1art,null);

        }
//--select ''[Articulo],''[Descripcion],''[Cantidad],''[Venta],''[Almacen]-->
        TextView Articulo = (TextView)convertView.findViewById(R.id.Articulo);
        TextView Descripcion = (TextView)convertView.findViewById(R.id.Descripcion);
        TextView Cantidad = (TextView)convertView.findViewById(R.id.Cantidad);
        TextView Venta = (TextView)convertView.findViewById(R.id.Venta);
        TextView Almacen = (TextView)convertView.findViewById(R.id.Almacen);
        //asignando valores
        Articulo.setText(arrayList.get(position).getArticulo().toString());
        Descripcion.setText(arrayList.get(position).getDescripcion().toString());
        Cantidad.setText(arrayList.get(position).getCantidad().toString());
        Venta.setText(arrayList.get(position).getVenta().toString());
        Almacen.setText(arrayList.get(position).getAlmacen().toString());


        return convertView;
    }//Fin View Adapter
}//Fin Adapter
