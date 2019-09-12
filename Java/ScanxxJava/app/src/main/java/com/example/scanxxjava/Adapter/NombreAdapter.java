package com.example.scanxxjava.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.scanxxjava.Model.xScanLista;
import com.example.scanxxjava.R;

import java.util.ArrayList;
//Adaptador par alistar items1 dentro del activity listar lista
public class NombreAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<xScanLista> arrayList;
    //creando construcctor de adapter
    public NombreAdapter(Context context, ArrayList<xScanLista> arrayList){
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

        TextView xscaneado = (TextView)convertView.findViewById(R.id.scaneado);
        //asignando valores
        xscaneado.setText(arrayList.get(position).getCodigo());
        return convertView;
    }
}
