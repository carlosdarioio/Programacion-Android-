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
    Button btnImprimirTicket,btnImprimirBD,btnImprimirEnt,btnCrearNC,btnImprimirFcarta;
    private RequestQueue queuexFactura,queuexFacturaBodega,queuexFacturacarta;


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
        btnCrearNC=findViewById(R.id.btnCrearNC);
        btnImprimirFcarta=findViewById(R.id.btnImprimirFcarta);

        btnImprimirTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                //url del post 1150219857
                String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPostAndroidImpFacturaTk";//trabajo
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
            }});//fun button Imprimir Ticket

        //Imprimir Factura Bodega
        btnImprimirBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                //url del post 1150219857
                String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPostAndroidImpFacturaBodega";//trabajo
                //--------------------------___________________________________
                queuexFacturaBodega = Volley.newRequestQueue(VerFactura.this);
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
                JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            txtErrorart.setText("Impresion Grande pendiente en : "+response.getString("response"));
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
                queuexFacturaBodega.add(request2);
                //-------------------------______________________________________
            }});//fun button Imprimir Factura Bodega

        //Imprimir Factura Carta
        btnImprimirFcarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //x aqui vas
                String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPostAndroidImpFacturaCarta";//trabajo
                //--------------------------___________________________________
                queuexFacturacarta = Volley.newRequestQueue(VerFactura.this);
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
                JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            txtErrorart.setText("Impresion Grande pendiente en : "+response.getString("response"));
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
                queuexFacturacarta.add(request2);
                //-------------------------______________________________________
            }});//fun button Imprimir Factura Carta
        //
        //Imprimir Entrega
        btnImprimirEnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Factura 1150219857
                String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPostAndroidImpEntrega";//trabajo
                //--------------------------___________________________________
                queuexFacturaBodega = Volley.newRequestQueue(VerFactura.this);
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
                JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            txtErrorart.setText("Impresion Entrega pendiente en : "+response.getString("response"));
                            Log.d("response ", response.toString());
                            //Log.d("response ", response.getString("status")+" 2 "+response.getString("value"));
                        } catch (Exception e) {
                            txtErrorart.setText("Error ent1");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        txtErrorart.setText("PostT Errorb1 "+error.toString());
                    }
                });
                queuexFacturaBodega.add(request2);
                //-------------------------______________________________________
            }});//fun button Imprimir Entrega

        //btnCrearNC
        btnCrearNC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Factura 1150219857
                String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPostAndroidCrearNC";//trabajo
                //--------------------------___________________________________
                queuexFacturaBodega = Volley.newRequestQueue(VerFactura.this);
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
                JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            txtErrorart.setText(" Respuesta : "+response.getString("response"));
                            Log.d("response ", response.toString());
                            //Log.d("response ", response.getString("status")+" 2 "+response.getString("value"));
                        } catch (Exception e) {
                            txtErrorart.setText("Error ent1");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        txtErrorart.setText("PostT Errorb1 "+error.toString());
                    }
                });
                queuexFacturaBodega.add(request2);
                //-------------------------______________________________________
            }});//fun button btnCrearNC


    }//Fin oncreate
    }//fin verfactu
    //------------------------------------------------------------------------------------





