package com.example.scanxxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scanxxjava.Model.xScanLista;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button xBtnIngresar;
    TextView xtct,xtxtcount;
    ArrayList<xScanLista> model = new ArrayList<>();
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xBtnIngresar=findViewById(R.id.btnIngresar);
        xtct=findViewById(R.id.txt);
        xtxtcount=findViewById(R.id.txtcount);



        //asignando funcion a ejecutar si apreta x boton mientras escirbe dentro del TextView xtct
        xtct.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_ENTER:
                            AgregandoEscaneo();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });


    }



    //Funcion para Mandar lista de escaneo a otra actividad
    public void TerminarEscaneo(View view) {

        Intent intent = new Intent(this, ListarLista.class);
        intent.putExtra("model",  model);
        startActivity(intent);
    }

    public void xPost(View view) {
        Toast.makeText(this, "Pendientes", Toast.LENGTH_SHORT).show();
    }

    //Agregando valor al arrayList y contando ingresados
    public void AgregandoEscaneo(){
        xScanLista m = new xScanLista();
        m.setCodigo(xtct.getText().toString());
        model.add(m);
        xtct.setText("");
        Toast.makeText(this, "Agregado "+model.get(count).getCodigo(), Toast.LENGTH_SHORT).show();
        count++;
        xtxtcount.setText("Van: "+ count);
    }
}
