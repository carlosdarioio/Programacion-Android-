package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONException;
import org.json.JSONObject;

public class DarDescuentoManual extends AppCompatActivity {
    EditText articulo,descuento,fecha;
    Button btnDescuento;
    TextView txtresponse;
    private RequestQueue queuexDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dar_descuento_manual);

        articulo=findViewById(R.id.articulo);
        descuento=findViewById(R.id.descuento);
        fecha=findViewById(R.id.fecha);
        btnDescuento=findViewById(R.id.btnDescuento);
        txtresponse=findViewById(R.id.response);


        //btnCrearNC
        btnDescuento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Factura 1150219857
                String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPostAndroidCrearNC";//trabajo
                //por aqui vas pendiente servicio
                //--------------------------___________________________________
                queuexDesc = Volley.newRequestQueue(DarDescuentoManual.this);
                JSONObject jsonRequest = new JSONObject();
                try
                {
                    jsonRequest.put("articulo",articulo.getText());
                    jsonRequest.put("descuento",descuento.getText());
                    jsonRequest.put("fecha",fecha.getText());
                }
                catch (JSONException e)
                {
                    Toast.makeText(DarDescuentoManual.this,"zError:",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            txtresponse.setText(" Respuesta : "+response.getString("response"));
                            Log.d("response ", response.toString());
                            //Log.d("response ", response.getString("status")+" 2 "+response.getString("value"));
                        } catch (Exception e) {
                            txtresponse.setText("Error ent1");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        txtresponse.setText("PostT Errorb1 "+error.toString());
                    }
                });
                queuexDesc.add(request2);
                //-------------------------______________________________________
            }});//fun button btnCrearNC

    }
}
