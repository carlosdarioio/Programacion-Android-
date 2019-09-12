package com.example.scanxxjava;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.scanxxjava.Adapter.NombreAdapter;
import com.example.scanxxjava.Model.xScanLista;

import java.util.ArrayList;

public class ListarLista extends AppCompatActivity {

    private ListView lista;
    private NombreAdapter nombresAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_lista);



        //--Obtendiendo Lista mandada por putExtra
        //ArrayList<xScanLista> model = (ArrayList<xScanLista>) getIntent().getSerializableExtra("model");
        ArrayList<xScanLista> model = (ArrayList<xScanLista>) getIntent().getSerializableExtra("model");

        /*
        ArrayList<xScanLista> model=new ArrayList<>();
        xScanLista m = new xScanLista();
        m.setCodigo("un dia duarlo con sentire me ");
        model.add(m);

        m = new xScanLista();
        m.setCodigo("alola tatataranatata ");
        model.add(m);*/


        //inicializar adapter
        nombresAdapter=new NombreAdapter(this,model);

        lista=(ListView)findViewById(R.id.lv_lista);//agregar adaptador en lista
        lista.setAdapter(nombresAdapter);

        //mostrando texto seleccionaod por cada clicik que da
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                xScanLista mScanLista=(xScanLista)nombresAdapter.getItem(position);
                Toast.makeText(getBaseContext(),"Tu cogido es "+mScanLista.getCodigo(), Toast.LENGTH_LONG).show();
                //pones sartactivity desde aqui
                //startActivity(DetallerActivity.getCallingIntent(context,mDetalles));


            }
        });
    }
}
