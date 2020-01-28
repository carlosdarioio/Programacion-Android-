package com.example.navigationdrawact.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.navigationdrawact.JsonClass.Marcaje;
import com.example.navigationdrawact.R;

import java.util.ArrayList;

public class MarcajeXCodigoApapter extends BaseAdapter {

    private Context context;
    private ArrayList<Marcaje> arrayList;
    //creando construcctor de adapter
    public MarcajeXCodigoApapter(Context context, ArrayList<Marcaje> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {        return arrayList.size();    }
    @Override
    public Object getItem(int position) {        return arrayList.get(position);    }
    @Override
    public long getItemId(int position) {        return position;    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        //----------------------
        if(convertView==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //item1 lo usas como general xd
            convertView=layoutInflater.inflate(R.layout.adaptercontentgeneral,null);
        }
        //pendiente crear irem factura dentro del  convertView
        TextView xDatosAdapter = (TextView)convertView.findViewById(R.id.adaptergeneraltextview);
        //asignando valores
        String valor=arrayList.get(position).getTRACVE();
        valor+=" "+arrayList.get(position).getCONSEC();
        valor+=" "+arrayList.get(position).getFECHA();
        valor+=" "+arrayList.get(position).getHORAMA();
        valor+=" "+arrayList.get(position).getLOCAL();
        xDatosAdapter.setText(valor);
        return convertView;
        //---------------------
    }
}
