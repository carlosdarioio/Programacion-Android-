package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.navigationdrawact.JsonClass.Articulo;
import com.example.navigationdrawact.JsonClass.Factura;
import com.example.navigationdrawact.JsonClass.FindArtxFacturaList;
import com.example.navigationdrawact.adapter.AdapterListArtFactura;
import com.example.navigationdrawact.adapter.AdapterListFacturas;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class VerFactura extends AppCompatActivity {
    private RequestQueue queueFindArt;
    private ListView lista;
    private AdapterListArtFactura Adapterart;
    TextView txtErrorart;
    Factura model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_factura);
        txtErrorart=findViewById(R.id.txtError);
        model = (Factura) getIntent().getSerializableExtra("model");
        Toast.makeText(getBaseContext(),"Factura "+model.getFACTURA(), Toast.LENGTH_LONG).show();
        Toast.makeText(getBaseContext(),"Cl "+model.getCliente(), Toast.LENGTH_LONG).show();
        Toast.makeText(getBaseContext(),"fecha "+model.getFecha(), Toast.LENGTH_LONG).show();
        Log.d("GetArtFacturasVolley "," start adapter ");//
        GetArtFacturasVolley();
        Log.d("GetArtFacturasVolley "," end adapter99 ");//



    }//Fin oncreate

    //GetListClass Lista
    //-----------------

    private void GetArtFacturasVolley()
    {
        queueFindArt = Volley.newRequestQueue(this);
        //http://10.1.201.5/DXInvIT/SapService.svc/FindArtxFactura/1350202020
        String url="http://10.1.201.5/DXInvIT/SapService.svc/FindArtxFactura/"+model.getFACTURA(); //Trabajo
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {

                    Gson gson = new Gson();
                    FindArtxFacturaList xListArt = gson.fromJson(response.toString(), FindArtxFacturaList.class); //response.toString() o txt
                    //txtError.setText("GetListClassVolley R: "+response.toString());
                    Log.d("xListArt1 ", xListArt.getMessage());
                    if(!xListArt.getArticulos().get(0).getArticulo().isEmpty())
                    {
                        txtErrorart.setText(model.getFACTURA()+" tiene "+xListArt.getArticulos().size()+" Resultados ");
                        Log.d("VF1 ",xListArt.getArticulos().get(0).getArticulo());//
                        //por aqui vas pendiente crear lista de articulos que asignaras al
                        //todo este rato trabado... quitar ' y "" de la descricion xd
                        //corregiste el servidor pendiente aser prueba
                        Adapterart=new AdapterListArtFactura(VerFactura.this,(ArrayList<Articulo>)xListArt.getArticulos());
                        lista=(ListView)findViewById(R.id.listafacturas);//agregar adaptador en lista
                        lista.setAdapter(Adapterart);
                        //---------------------
                    }
                    else
                    {
                        Log.d("VF x ","...");//
                        txtErrorart.setText("Sin Resultados "+xListArt.getArticulos().get(0).getArticulo()+" xx");
                    }

                } catch (Exception e) {
                    txtErrorart.setText("v1 "+e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                txtErrorart.setText("fE9 "+error.getMessage().toString());
            }
        });
        queueFindArt.add(request);
    }//fin GetArt
    }//fin verfactu
    //------------------------------------------------------------------------------------





