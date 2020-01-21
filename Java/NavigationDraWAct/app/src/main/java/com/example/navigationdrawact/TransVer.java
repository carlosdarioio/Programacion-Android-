package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.navigationdrawact.JsonClass.Transferencium;

import org.json.JSONException;
import org.json.JSONObject;

public class TransVer extends AppCompatActivity {

    TextView txtError,transferencianum,transferenciafecha,tansferenciahasta;
    Transferencium model;
    Button tranfbtnImprimirT;
    private RequestQueue queueImprimirT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_ver);
        txtError=findViewById(R.id.txtError);

        model = (Transferencium) getIntent().getSerializableExtra("model");
        Log.d("model",model.getDocNum());

        transferencianum=findViewById(R.id.transferencianum);
        transferenciafecha=findViewById(R.id.transferenciafecha);
        tansferenciahasta=findViewById(R.id.tansferenciahasta);
        txtError=findViewById(R.id.txtError);

        transferencianum.setText("Numero: "+ model.getDocNum().toString());
        transferenciafecha.setText("Fecha: "+ model.getFecha().toString());
        tansferenciahasta.setText("Desde-Hasta: "+ model.getA()+" "+model.getDe());

        Button transbtnImprimirT=findViewById(R.id.transbtnImprimirT);
         transbtnImprimirT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                //url del post 1150219857
                String url = "http://10.1.201.5/DXInvIT/SapService.svc/xPrintTransferencia";//trabajo
                //--------------------------___________________________________
                queueImprimirT = Volley.newRequestQueue(TransVer.this);
                JSONObject jsonRequest = new JSONObject();
                    try
                    {
                        jsonRequest.put("valor",model.getDocNum().toString());//txt1.getText().toString()
                    }
                    catch (JSONException e)
                    {
                        Toast.makeText(TransVer.this,"xError:",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                        try
                        {
                            txtError.setText("R : "+response.getString("response"));
                            Log.d("response ", response.toString());
                            //Log.d("response ", response.getString("status")+" 2 "+response.getString("value"));
                        } catch (Exception e) {
                            txtError.setText("Error e1");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        txtError.setText("PostTextVolley Errorx9 "+error.toString());
                    }
                });
                queueImprimirT.add(request);
                //-------------------------______________________________________
            }});//fun button Imprimir Ticket

    }
}
