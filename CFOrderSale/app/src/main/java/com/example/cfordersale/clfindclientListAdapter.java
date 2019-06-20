package com.example.cfordersale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class clfindclientListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ClientModel> dataModelArrayList;

    public clfindclientListAdapter(Context context, ArrayList<ClientModel> dataModelArrayList) {

        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_client, null, true);



            holder.codigo = (TextView) convertView.findViewById(R.id.nombre);
            holder.cliente = (TextView) convertView.findViewById(R.id.Cliente);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }



        holder.codigo.setText("codigo: "+dataModelArrayList.get(position).getcodigo());
        holder.cliente.setText("estado: "+dataModelArrayList.get(position).getcliente());

        return convertView;
    }

    private class ViewHolder {

        protected TextView codigo, cliente;

    }

}
