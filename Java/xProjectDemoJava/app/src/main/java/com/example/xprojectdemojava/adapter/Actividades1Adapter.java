package com.example.xprojectdemojava.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xprojectdemojava.Actividades1Ver;
import com.example.xprojectdemojava.ActividadesCrear;
import com.example.xprojectdemojava.model.ModelListaActividades;
import com.example.xprojectdemojava.R;
import com.example.xprojectdemojava.model.ModelListaActividades;

import java.util.ArrayList;

//Adaptador par alistar items1 dentro del activity listar lista
public class Actividades1Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<ModelListaActividades> arrayList;
    //creando construcctor de adapter
    public Actividades1Adapter(Context context, ArrayList<ModelListaActividades> arrayList){
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
            convertView=layoutInflater.inflate(R.layout.actitem1,null);
        }
        TextView xscaneado = (TextView)convertView.findViewById(R.id.scaneado);
        //asignando valores
        xscaneado.setText(arrayList.get(position).getCodigo());


        //zzzzzzzzzzzzzzzzzzzzz
        //Handle button and add onClickListener

        //Si presiona el boton de ver
        Button Ver = (Button) convertView.findViewById(R.id.act1btnVer);
        Ver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final int x = (int) getItemId(position);
                Toast.makeText(parent.getContext(),"you clicked "+ x , Toast.LENGTH_SHORT).show();
                //Intent zoom=new Intent(mContext, Profile.class);
                //mContext.startActivity(zoom);
                //v.getContext().startActivity(zoom);
                Intent zoom=new Intent(parent.getContext(), Actividades1Ver.class);
                zoom.putExtra("id",arrayList.get(position).getCodigo());
                parent.getContext().startActivity(zoom);
            }
        });


        //zzzzzzzzzzzzzzzzzzzzzzzzzzz



        return convertView;
    }
}
