package com.example.scanxxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.scanxxjava.Model.ListScanJava;
import com.example.scanxxjava.Model.ScanJava;
import com.example.scanxxjava.Model.xScanLista;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button xBtnIngresar;
    TextView xtct,xtxtcount;
    ArrayList<xScanLista> model = new ArrayList<>();
    int count=0;
    private RequestQueue queue2,queue3;

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
        PostVolleyinsert("Ataquitoday");
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


    //Aunque ya ves no es tan facil empezar, lo imposible s epuede lograr-------------------------------------------------------------
    /**
     * Funciones alola
     */
    private void PostVolleyinsert(String doc)
    {
        final String url = "http://10.1.0.93:81/SapService.svc/xPostScanJava";//trabajo
        //final String url = "http://192.168.0.18:80/CFService/SapService.svc/xPostScanJava";//casa xPostScanJava!testPostScanJava
        // Instantiate the RequestQueue.
        queue2 = Volley.newRequestQueue(this);
        queue3 = Volley.newRequestQueue(this);
        JSONObject xRootObject = new JSONObject();
        //---
        ListScanJava sList=new ListScanJava();
        List<ScanJava> xListScanJ = new ArrayList<ScanJava>();

        ScanJava obj1 = new ScanJava();
        obj1.setdocnum("val1");
        xListScanJ.add(obj1);
        ScanJava obj2 = new ScanJava();
        obj2.setdocnum("val2");
        xListScanJ.add(obj2);

        //sList.setData(xListScanJ);

        //-----
        try
        {
            //xRootObject.put("ScanJava",obj2);//ScanJava--xRootObject
            xRootObject.put("docnum","papadaosea");
        } catch (JSONException e) {
            Toast.makeText(MainActivity.this,"Error2:",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        if(doc!="" && doc.length()>3){
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, xRootObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response)
                {
                    try
                    {
                        //un resultado formato json
                        //response.getString("response")
                        //varios resultados formato json
                        //mJSONArray=response.getJSONArray("users");
                        //mJSONObject = mJSONArray.getJSONObject(0);
                        Log.d("response ", response.toString());

                        Toast.makeText(MainActivity.this,"result:"+response.getString("response"),Toast.LENGTH_LONG).show();
                        //Toast.makeText(MainActivity.this,"result:"+response.toString(),Toast.LENGTH_LONG).show();

                        xtxtcount.setText(response.toString());

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this,"Error2:",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }//contralor
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this,"Error3: "+error.toString(),Toast.LENGTH_LONG).show();
                }
            });
            queue2.add(request);
            xtxtcount.setText("");
        }//Fin if
        else{Toast.makeText(MainActivity.this," osea no puede ser <6 ",Toast.LENGTH_LONG).show();}
    }//fin PostVolleyinsert

}
