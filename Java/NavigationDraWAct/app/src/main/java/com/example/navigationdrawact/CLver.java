package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawact.JsonClass.CLContacInfo;


public class CLver extends AppCompatActivity {
    TextView txtErrorart,xcl,cltel1,cltel2,clcel;
    CLContacInfo model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clver);

        txtErrorart=findViewById(R.id.txtError);
        model = (CLContacInfo) getIntent().getSerializableExtra("model");
        Log.d("model",model.getNombre());


        xcl=findViewById(R.id.cl);
        cltel1=findViewById(R.id.cltel1);
        cltel2=findViewById(R.id.cltel2);
        clcel=findViewById(R.id.clcel);

        xcl.setText("Cliente: "+ model.getCodigo()+" "+model.getNombre());
        cltel1.setText("Telefono1: "+ model.getPhone1());
        cltel2.setText("Telefono2: "+ model.getPhone2());
        clcel.setText("Celular: "+ model.getCelular());

        Button clbtnblckUn;
        clbtnblckUn=findViewById(R.id.clbtnblckUn);
        clbtnblckUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(getBaseContext()," Proximamente",Toast.LENGTH_LONG).show();
            }
        });

    }
}
