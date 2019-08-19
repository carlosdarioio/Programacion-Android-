package com.example.gridviewadapterjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class DetallesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //asignando layout
        setContentView(R.layout.activity_detalles);

        //cambiando titulo por el valor seleccionado de item grid
        //valor enviado desde main activity
        getSupportActionBar().setTitle(getIntent().getExtras().get("Nombre").toString());

    }
}
