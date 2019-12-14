package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navigationdrawact.JsonClass.Factura;
import com.example.navigationdrawact.JsonClass.FindFacturaList;
import com.example.navigationdrawact.adapter.AdapterListFacturas;

import java.util.ArrayList;

public class ListarFacturas extends AppCompatActivity {
    private ListView lista;
    private AdapterListFacturas nombresAdapter;
    FindFacturaList xListFacturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_facturas);

        xListFacturas=(FindFacturaList) getIntent().getSerializableExtra("model");
        Log.d("Get xListFacturas ",xListFacturas.getFacturas().size()+" y");//
        ArrayList<Factura> model = (ArrayList<Factura>) xListFacturas.getFacturas();
        Log.d("Get model ",model.size()+" y");//

        nombresAdapter=new AdapterListFacturas(this,model);

        lista=(ListView)findViewById(R.id.listafacturas);//agregar adaptador en lista
        lista.setAdapter(nombresAdapter);

        //mostrando texto seleccionaod por cada clicik que da
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Factura mScanLista=(Factura)nombresAdapter.getItem(position);
                Toast.makeText(getBaseContext(),"Tu cogido es "+mScanLista.getFACTURA(), Toast.LENGTH_LONG).show();
                //pones sartactivity desde aqui
                //startActivity(DetallerActivity.getCallingIntent(context,mDetalles));


            }
        });//Find lista.setOnItemClickListener


    }
}
