package com.example.xprojectdemojava;
//NOTA
//No tocar este se como como formato general
// pa copiar y pegar en todo el que creees
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class OperariosView1Demo extends AppCompatActivity {
//clase solo para ver el formato general de las paginas
    Button btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operarios_view1_demo);

        //Accion para mostar menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Accion para mostrar el boton de ir a inicio en el menu
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //Desactivas la opcion de volver atras
            //actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btnMenu=findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OperariosView1Demo.this,MenuPrincipal.class);
                startActivity(intent);

            }
        });

    }//fIN Oncreate


    //--------------------------------MENUUUUUUUU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_favorite) {
            Intent intent=new Intent(OperariosView1Demo.this,MenuPrincipal.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //------------------

}//Fin OperariosView1Demo
