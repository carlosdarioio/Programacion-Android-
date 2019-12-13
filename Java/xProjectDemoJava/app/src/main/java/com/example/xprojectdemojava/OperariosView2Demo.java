package com.example.xprojectdemojava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class OperariosView2Demo extends AppCompatActivity {
//clase solo para estableces formulairo que se usaran (select, listas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operarios_view2_demo);

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

        Button btnMenu=findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OperariosView2Demo.this,xMenu.class);
                startActivity(intent);

            }
        });
        //Tema



        //Pendientes:
        /*
        Formato label Tema.
        Formato label SubTema.
        Formato label Descripcion.
        Formaro Boton.
        Formato Select (datos locales).
        Formato Select (on changedatos locales).
        Formato Select (datos Json)
        Formato Select (on changedatos Json)
        Formato gridview
        * */

        //spinner----------------------------
        //Agregando valores y listandolos
        String[] arraySpinner = new String[] {"025", "002", "053", "045" };
        Spinner s = (Spinner) findViewById(R.id.spinner_Select);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        //Accion si seleciona x spinner
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //----------
                //spinner2----------------------------Si selecciona el 3 actualiza
                if(position==3){
                //Actualizando valores y listandolos
                String[] arraySpinner3 = new String[] { "C025", "C002", "C053", "C045"        };
                Spinner sC = (Spinner) findViewById(R.id.spinner_Select2);
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(OperariosView2Demo.this,
                        android.R.layout.simple_spinner_item, arraySpinner3);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sC.setAdapter(adapter3);
                 }
                //fin spinnder3-----------------------

                //-------------
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        //fin spinnder-----------------------

        //spinner2----------------------------
        //Asignando valores
        String[] arraySpinner2 = new String[] {"z025", "z002", "z053", "z045"};
        Spinner sz = (Spinner) findViewById(R.id.spinner_Select2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sz.setAdapter(adapter2);
        //fin spinnder2-----------------------

    }//Fin Oncreate


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
            Intent intent=new Intent(OperariosView2Demo.this,xMenu.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //------------------

}//Fin
