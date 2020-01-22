package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class TransReimprimirGuia extends AppCompatActivity {
    private RequestQueue queuePrintTransG;
    TextView txtError;
    Button TRGNbtnImprimir;
    EditText TRGNguia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_reimprimir_guia);


        txtError=findViewById(R.id.TRGNtxtError);
        TRGNguia=findViewById(R.id.TRGNguia);

        TRGNbtnImprimir=findViewById(R.id.TRGNbtnImprimir);
        TRGNbtnImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                //--...............
                //Factura 1150219857
                if(TRGNguia.getText().toString().length()>3){
                    String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPrintGuiaTransferencia";//trabajo
                    //--------------------------___________________________________
                    queuePrintTransG = Volley.newRequestQueue(TransReimprimirGuia.this);
                    JSONObject jsonRequest = new JSONObject();
                    try
                    {
                        jsonRequest.put("valor",TRGNguia.getText());
                    }
                    catch (JSONException e)
                    {
                        Toast.makeText(TransReimprimirGuia.this,"zError:",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                    JsonObjectRequest request3 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try
                            {
                                txtError.setText(" Respuesta : "+response.getString("response"));
                                Log.d("response ", response.toString());
                                TRGNguia.setText("");
                                //Log.d("response ", response.getString("status")+" 2 "+response.getString("value"));
                            } catch (Exception e) {
                                txtError.setText("Error ent1");
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            txtError.setText("PostT Errorb1 "+error.toString());
                        }
                    });
                    queuePrintTransG.add(request3);
                    //-------------------------______________________________________
                }else{txtError.setText(" Rellenar todos los datos ");}

                //--................
            }
        });

    }//Fin OnCreate





}//Fin ALl
