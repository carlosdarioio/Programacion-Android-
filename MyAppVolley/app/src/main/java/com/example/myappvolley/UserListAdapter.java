package com.example.myappvolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<UserModel> dataModelArrayList;

    public UserListAdapter(Context context, ArrayList<UserModel> dataModelArrayList) {

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
            convertView = inflater.inflate(R.layout.lv_player, null, true);


            holder.id = (TextView) convertView.findViewById(R.id.id);
            holder.nombre = (TextView) convertView.findViewById(R.id.nombre);
            holder.estado = (TextView) convertView.findViewById(R.id.estado);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }


        holder.id.setText("id: "+dataModelArrayList.get(position).getid());
        holder.nombre.setText("nombre: "+dataModelArrayList.get(position).getNombre());
        holder.estado.setText("estado: "+dataModelArrayList.get(position).getestado());

        return convertView;
    }



    private class ViewHolder {

        protected TextView id, nombre, estado;

    }

}