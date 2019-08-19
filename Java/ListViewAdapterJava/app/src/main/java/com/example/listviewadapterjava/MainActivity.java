package com.example.listviewadapterjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //creando lista con arreglo de clase
        ArrayList<MDuvatec> model=new ArrayList<>();
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
        adapter=new Adapter(this,model);

        lista=(ListView)findViewById(R.id.ma_lv_lista);//agregar adaptador en lista
        lista.setAdapter(adapter);

        //mostrando texto seleccionaod por cada clicik que da
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try{
                    MDuvatec mDuvatec = (MDuvatec) adapter.getItem(position);

                 Log.e("Mduvatec",mDuvatec.getCodigo()+"-"+mDuvatec.getNombre());
      Toast.makeText(getBaseContext(),"Tu cogido es "+mDuvatec.getNombre(), Toast.LENGTH_LONG).show();



                }catch (Exception e){
                    e.printStackTrace();

                }
            }
        });
    }
}
