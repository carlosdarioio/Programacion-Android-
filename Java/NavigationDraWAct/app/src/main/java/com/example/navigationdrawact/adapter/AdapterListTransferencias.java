package com.example.navigationdrawact.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.navigationdrawact.JsonClass.Transferencium;
import com.example.navigationdrawact.R;
import com.example.navigationdrawact.TransVer;

import java.util.ArrayList;

public class AdapterListTransferencias extends BaseAdapter {

    private Context context;
    private ArrayList<Transferencium> arrayList;
    //creando construcctor de adapter
    public AdapterListTransferencias(Context context, ArrayList<Transferencium> arrayList){
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //por auqi vas definiendo item1Art
            convertView=layoutInflater.inflate(R.layout.transferenciasitem1,null);

        }

//--select ''[Articulo],''[Descripcion],''[Cantidad],''[Venta],''[Almacen]-->
        TextView xTransferenciasitem = (TextView)convertView.findViewById(R.id.Transferenciasitem);
        //asignando valores
        xTransferenciasitem.setText(arrayList.get(position).getDocNum()+" "+arrayList.get(position).getFecha()+" "+arrayList.get(position).getDe()+"-"+arrayList.get(position).getA());

        //Onclick Action-------------------------------------------------------------
        xTransferenciasitem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TransVer.class);

                intent.putExtra("model",  arrayList.get(position));

                v.getContext().startActivity(intent);
            }
        });
        //Fin Onclick Action---------------------------------------------------------


        return convertView;
    }//Fin View Adapter
}
