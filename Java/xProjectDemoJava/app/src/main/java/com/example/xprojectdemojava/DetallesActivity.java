package com.example.xprojectdemojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu_file, menu);
        return true;
    }
}
