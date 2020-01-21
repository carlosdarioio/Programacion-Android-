package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navigationdrawact.JsonClass.FindTransfList;
import com.example.navigationdrawact.JsonClass.Transferencium;
import com.example.navigationdrawact.adapter.AdapterListTransferencias;

import java.util.ArrayList;


public class TransListar extends AppCompatActivity {
    private ListView lista;
    private AdapterListTransferencias nombresAdapter;
    FindTransfList xTransfList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_listar);

        xTransfList=(FindTransfList) getIntent().getSerializableExtra("model");
        Log.d("Get xListFacturas ",xTransfList.getTransferencia().size()+" y");//
        ArrayList<Transferencium> model = (ArrayList<Transferencium>) xTransfList.getTransferencia();
        Log.d("Get model ",model.size()+" y");//

        nombresAdapter=new AdapterListTransferencias(this,model);

        lista=(ListView)findViewById(R.id.Transferenciaslista);//agregar adaptador en lista
        lista.setAdapter(nombresAdapter);

        //mostrando texto seleccionaod por cada clicik que da
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Transferencium mScanLista=(Transferencium)nombresAdapter.getItem(position);
                Toast.makeText(getBaseContext(),"Tu cogido es "+mScanLista.getDocNum(), Toast.LENGTH_LONG).show();
                //pones sartactivity desde aqui
                //startActivity(DetallerActivity.getCallingIntent(context,mDetalles));


            }
        });//Find lista.setOnItemClickListener


    }//Fon Oncreate
}
