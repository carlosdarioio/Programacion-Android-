package com.example.gridviewadapterjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    //creando variable adaptador
    private  GridAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       //cReando array de adapter y asignandole valores
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("alola");
        arrayList.add("hoenn");
        arrayList.add("melani");
        arrayList.add("Baleria");
        arrayList.add("cabana");


       //obtendiendo gridview
        gridView=(GridView) findViewById(R.id.am_gv_gridview);
        //inicializando adapter ocupa context y araylist!!
        adapter=new GridAdapter(this,arrayList);

        //asignanod adaptador a gridview
        gridView.setAdapter(adapter);

        //funcionan para abrir otra actividad si dan click
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,DetallesActivity.class);
                //pasando parametor clickeado de adapter //x ejemplo puede ser valor clase u objeto
                intent.putExtra("Nombre",adapter.getItem(position).toString());
                startActivity(intent);

            }
        });
    }
}
