package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navigationdrawact.JsonClass.CLContacInfo;
import com.example.navigationdrawact.JsonClass.FindClList;
import com.example.navigationdrawact.adapter.AdapterListCl;


import java.util.ArrayList;

public class ClListar extends AppCompatActivity {
    private ListView lista;
    private AdapterListCl nombresAdapter;
    FindClList xListCl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl_listar);

        xListCl=(FindClList) getIntent().getSerializableExtra("model");
        Log.d("Cl Listar xListCl ",xListCl.getCLContacInfo().size()+" ");//
        ArrayList<CLContacInfo> model = (ArrayList<CLContacInfo>) xListCl.getCLContacInfo();
        Log.d("Cl Listar ArrayList  ",model.size()+" ");//

        nombresAdapter=new AdapterListCl(this,model);

        lista=(ListView)findViewById(R.id.listacl);//agregar adaptador en lista
        lista.setAdapter(nombresAdapter);

        //mostrando texto seleccionaod por cada clicik que da
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CLContacInfo mScanLista=(CLContacInfo)nombresAdapter.getItem(position);
                Toast.makeText(getBaseContext(),"Tu cogido es "+mScanLista.getNombre(), Toast.LENGTH_LONG).show();
                //pones sartactivity desde aqui
                //startActivity(DetallerActivity.getCallingIntent(context,mDetalles));


            }
        });//Find lista.setOnItemClickListener
    }
}
