package com.example.xprojectdemojava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.xprojectdemojava.adapter.Actividades1Adapter;
import com.example.xprojectdemojava.model.ModelListaActividades;

import java.util.ArrayList;

public class Actividades1 extends AppCompatActivity {
    Button btnMenu;

    private ListView lista;
    private Actividades1Adapter nombresAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades1);

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
                Intent intent=new Intent(getBaseContext(),MenuPrincipal.class);
                startActivity(intent);

            }
        });

        Button actbtnCrear=findViewById(R.id.actbtnCrear);
        actbtnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),ActividadesCrear.class);
                startActivity(intent);

            }
        });




        //Cargando datos
        //ArrayList<ModelListaActividades> model = (ArrayList<ModelListaActividades>) getIntent().getSerializableExtra("model");


        ArrayList<ModelListaActividades> model=new ArrayList<>();
        ModelListaActividades m = new ModelListaActividades();
        m.setCodigo("Control Suelos ");
        model.add(m);

        m = new ModelListaActividades();
        m.setCodigo("Cortes ");
        model.add(m);

        m = new ModelListaActividades();
        m.setCodigo("Establecimiento Plantas ");
        model.add(m);

        //inicializar adapter
        nombresAdapter=new Actividades1Adapter(this,model);

        lista=(ListView)findViewById(R.id.lista_actividades);//agregar adaptador en lista
        lista.setAdapter(nombresAdapter);

        //mostrando texto seleccionaod por cada clicik que da
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelListaActividades mScanLista=(ModelListaActividades)nombresAdapter.getItem(position);
                Toast.makeText(getBaseContext(),"Tu cogido es "+mScanLista.getCodigo(), Toast.LENGTH_LONG).show();
                //pones sartactivity desde aqui
                //startActivity(DetallerActivity.getCallingIntent(context,mDetalles));


            }
        });


        //Fon cargando datos


    }//Fion oncreate
    //--------------------------------
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
            Intent intent=new Intent(getBaseContext(),MenuPrincipal.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //------------------
}//Fin Actividades1
