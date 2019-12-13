package com.example.navigationdrawact.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.navigationdrawact.JsonClass.Factura;
import com.example.navigationdrawact.JsonClass.FindFacturaList;
import com.example.navigationdrawact.R;

import java.util.ArrayList;

//Adaptador par alistar items1 dentro del activity listar lista
public class AdapterListFacturas extends BaseAdapter {
    private Context context;
    private ArrayList<Factura> arrayList;
    //creando construcctor de adapter
    public AdapterListFacturas(Context context, ArrayList<Factura> arrayList){
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
            convertView=layoutInflater.inflate(R.layout.item1,null);

        }

        TextView xscaneado = (TextView)convertView.findViewById(R.id.itemfactura);
        //asignando valores
        xscaneado.setText(arrayList.get(position).getFACTURA());
        return convertView;
    }
}
