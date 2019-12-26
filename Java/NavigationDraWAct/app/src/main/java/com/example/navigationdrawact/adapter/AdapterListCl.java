package com.example.navigationdrawact.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.navigationdrawact.CLver;
import com.example.navigationdrawact.JsonClass.CLContacInfo;
import com.example.navigationdrawact.R;

import java.util.ArrayList;

public class AdapterListCl extends BaseAdapter {


    private Context context;
    private ArrayList<CLContacInfo> arrayList;
    //creando construcctor de adapter
    public AdapterListCl(Context context, ArrayList<CLContacInfo> arrayList){
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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        if(convertView==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //pendiente crear item Cl
            convertView=layoutInflater.inflate(R.layout.item1,null);

        }

        //pendiente crear irem factura dentro del  convertView
        TextView xDatosCl = (TextView)convertView.findViewById(R.id.itemfactura);
        //asignando valores
        xDatosCl.setText(arrayList.get(position).getCodigo()+" "+arrayList.get(position).getNombre());

        //Onclick Action-------------------------------------------------------------
        xDatosCl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CLver.class);
                intent.putExtra("model",arrayList.get(position));
                v.getContext().startActivity(intent);
            }
        });
        //Fin Onclick Action---------------------------------------------------------
        return convertView;
    }//Fin View Adapter


}
