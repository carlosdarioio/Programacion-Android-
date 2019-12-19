package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.navigationdrawact.JsonClass.Factura;
import com.example.navigationdrawact.adapter.AdapterListArtFactura;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class VerFactura extends AppCompatActivity {
    TextView txtErrorart,vffactura,Vffecha,vfcl;
    Factura model;
    Button btnImprimirTicket,btnImprimirBD,btnImprimirEnt,btnCancelarEntrega;
    private RequestQueue queuexFactura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_factura);
        txtErrorart=findViewById(R.id.txtError);
        model = (Factura) getIntent().getSerializableExtra("model");
        Log.d("model",model.getFACTURA());


        vffactura=findViewById(R.id.vffactura);
        Vffecha=findViewById(R.id.Vffecha);
        vfcl=findViewById(R.id.vfcl);

        vffactura.setText("Factura: "+ model.getFACTURA());
        Vffecha.setText("Fecha: "+ model.getFecha());
        vfcl.setText("Cliente: "+ model.getCliente());


        btnImprimirTicket=findViewById(R.id.btnImprimirTicket);
        btnImprimirBD=findViewById(R.id.btnImprimirBD);
        btnImprimirEnt=findViewById(R.id.btnImprimirEnt);
        btnCancelarEntrega=findViewById(R.id.btnCancelarEntrega);

        btnImprimirTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                //url del post
                String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPostAndroidImpFacturaTk";//trabajo

                //por aqui vas creando el objeto para enviarlo por posat
                //--------------------------___________________________________
                queuexFactura = Volley.newRequestQueue(VerFactura.this);

                JSONObject jsonRequest = new JSONObject();
                try
                {
                    jsonRequest.put("Factura",model.getFACTURA());//txt1.getText().toString()
                }
                catch (JSONException e)
                {
                    Toast.makeText(VerFactura.this,"xError:",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            txtErrorart.setText("Impresion pendiente en : "+response.getString("response"));
                            Log.d("response ", response.toString());
                            //Log.d("response ", response.getString("status")+" 2 "+response.getString("value"));
                        } catch (Exception e) {
                            txtErrorart.setText("Error e1");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        txtErrorart.setText("PostTextVolley Errorx9 "+error.toString());
                    }
                });
                queuexFactura.add(request);


                //-------------------------______________________________________


            }});//fun button


    }//Fin oncreate
    }//fin verfactu
    //------------------------------------------------------------------------------------





