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
import com.example.navigationdrawact.JsonClass.FindFacturaList;
import com.example.navigationdrawact.adapter.AdapterListArtFactura;
import com.example.navigationdrawact.adapter.AdapterListFacturas;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class VerFactura extends AppCompatActivity {
    private RequestQueue queueFindFactura;
    private ListView lista;
    private AdapterListArtFactura nombresAdapter;
    TextView txtError;
    Factura model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_factura);
        model = (Factura) getIntent().getSerializableExtra("model");
        Toast.makeText(getBaseContext(),"Factura "+model.getFACTURA(), Toast.LENGTH_LONG).show();
        Toast.makeText(getBaseContext(),"Cl "+model.getCliente(), Toast.LENGTH_LONG).show();
        Toast.makeText(getBaseContext(),"fecha "+model.getFecha(), Toast.LENGTH_LONG).show();
        GetArtFacturasVolley();


    }//Fin oncreate

    //GetListClass Lista
    //-----------------

    private void GetArtFacturasVolley()
    {
        queueFindFactura = Volley.newRequestQueue(this);
        //http://10.1.201.5/DXInvIT/SapService.svc/FindArtxFactura/1010179306
        String url="http://10.1.201.5/DXInvIT/SapService.svc/FindArtxFactura/"+model.getFACTURA(); //Trabajo
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    Gson gson = new Gson();
                    FindArtxFacturaList xListArticulos = gson.fromJson(response.toString(), FindArtxFacturaList.class); //response.toString() o txt
                    if(!xListArticulos.getArticulos().get(0).getDescripcion().isEmpty())
                    {
                        txtError.setText(model.getFACTURA()+" tuvo "+xListArticulos.getArticulos().size()+" Resultados ");
                        Log.d("Get x ",xListArticulos.getArticulos().get(0).getDescripcion());//


                        //------------Mostrando articulos
                        ArrayList<Articulo> modelArt = (ArrayList<Articulo>) xListArticulos.getArticulos();
                        Log.d("Get model2 ","antes de adapter");//

                        nombresAdapter=new AdapterListArtFactura(VerFactura.this,modelArt);
                        Log.d("Get model3 "," despues de adapter");//
                        //por aqui vas comprobar si funciona y se ven los datos
                        //pasar de ListView a LinearLayout
                        lista=(ListView)findViewById(R.id.lista_art_de_facturas);//agregar adaptador en lista
                        lista.setAdapter(nombresAdapter);
                        Log.d("Get model4 "," despues de lista");//

                        //------------------Fin moftrando artoculos
                    }
                    else
                    {
                        Log.d("Get z ",xListArticulos.getArticulos().get(0).getAlmacen());//
                        txtError.setText("Sin Resultados "+xListArticulos.getArticulos().get(0).getCantidad()+" xx");
                    }

                } catch (Exception e) {
                    txtError.setText("e1 "+e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                txtError.setText("E2 "+error.getMessage().toString());
            }
        });
        queueFindFactura.add(request);
    }
    //------------------------------------------------------------------------------------

//Fin VerFacturas
 }
