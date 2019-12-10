package com.example.xprojectdemojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuInicial extends AppCompatActivity {

    private ListView gridView;
    //creando variable adaptador
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);


        //cReando array de adapter y asignandole valores
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("alola");
        arrayList.add("hoenn");
        arrayList.add("melani");
        arrayList.add("Baleria");
        arrayList.add("cabana");


        //obtendiendo gridview
        gridView=(ListView) findViewById(R.id.am_gv_gridview);
        //inicializando adapter ocupa context y araylist!!
        adapter=new ListAdapter(this,arrayList);

        //asignanod adaptador a gridview
        gridView.setAdapter(adapter);

        //funcionan para abrir otra actividad si dan click
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //idea pendiente: dependiendo de position
                //definir class a abrir
                Intent intent=new Intent(MenuInicial.this,DetallesActivity.class);
                //pasando parametor clickeado de adapter //x ejemplo puede ser valor clase u objeto
                intent.putExtra("Nombre",adapter.getItem(position).toString());
                startActivity(intent);

            }
        });

    }
}
