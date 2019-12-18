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
                Gson gson = new Gson();
                JSONObject xRootObject = new JSONObject();
                try
                {
                    //String json =gson.toJson(model);
                    String json = new Gson().toJson(model);
                    Log.d("8val puetp","{\"xRootObject\":"+json+"}");
                    xRootObject.put("xRootObject","{\"xRootObject\":"+json+"}");
                } catch (JSONException e) {
                    Log.d("put Error2:",e.getMessage());
                    e.printStackTrace();
                }
                if(model.size()>0){
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, xRootObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try {
                                Log.d("PostVolley response ", response.toString());
                                xtxtcount.setText(response.toString());
                            }
                            catch (Exception e) {
                                Log.d("Error2:",e.getMessage());
                                e.printStackTrace();
                            } //contralor
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            Log.d("Error3: ",error.toString());
                        }
                    });
                    queue3.add(request);
                    xtxtcount.setText("");
                }//Fin if
                else{Toast.makeText(MainActivity.this," No se ha ingresado nada ",Toast.LENGTH_LONG).show();}
                //-------------------------______________________________________


            }
        });


    }//Fin oncreate
    }//fin verfactu
    //------------------------------------------------------------------------------------





