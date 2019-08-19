package com.example.intentobjectjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.intentobjectjava.activity.DetallerActivity;
import com.example.intentobjectjava.adapter.NombreAdapter;
import com.example.intentobjectjava.model.MDetalles;
import com.example.intentobjectjava.model.MDuvatec;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private NombreAdapter nombresAdapter;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;

        ArrayList<MDuvatec> model = new ArrayList<>();

        MDuvatec m = new MDuvatec();
        m.setNombre("alola");
        m.setDescripcion("7tima region");
        m.setCodigo(7);
        model.add(m);

        m = new MDuvatec();
        m.setNombre("Hoenn");
        m.setDescripcion("2ra region");
        m.setCodigo(3);
        model.add(m);

        m = new MDuvatec();
        m.setNombre("kanto");
        m.setDescripcion("1ra region");
        m.setCodigo(1);
        model.add(m);

        m = new MDuvatec();
        m.setNombre("magnemite");
        m.setDescripcion("favorito");
        m.setCodigo(99);
        model.add(m);


        //inicializar adapter
        nombresAdapter=new NombreAdapter(this,model);

        lista=(ListView)findViewById(R.id.ma_lv_lista);//agregar adaptador en lista
        lista.setAdapter(nombresAdapter);

        //mostrando texto seleccionaod por cada clicik que da
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MDuvatec mDuvatec=(MDuvatec)nombresAdapter.getItem(position);
                MDetalles mDetalles=new MDetalles();
                mDetalles.setNombre(mDuvatec.getNombre());
                mDetalles.setDescripcion(mDuvatec.getDescripcion());
                mDetalles.setImagenUrl("https://upload.wikimedia.org/wikipedia/commons/3/34/Android_Studio_icon.svg");


                startActivity(DetallerActivity.getCallingIntent(context,mDetalles));


            }
        });
    }
}
