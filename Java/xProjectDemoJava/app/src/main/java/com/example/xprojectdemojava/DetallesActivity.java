package com.example.xprojectdemojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//clase tets pa mostrar contenido
public class DetallesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //cambiando titulo por el valor seleccionado de item List
        //valor enviado desde main activity
        getSupportActionBar().setTitle(getIntent().getExtras().get("Nombre").toString());
    }
}
