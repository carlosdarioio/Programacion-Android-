package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.example.navigationdrawact.JsonClass.FindTransfList;
import com.example.navigationdrawact.JsonClass.Transferencium;
import com.google.gson.Gson;

import org.json.JSONObject;


public class TransBuscar2 extends AppCompatActivity {
    private RequestQueue Tranfqueue;
    TextView TranstxtError;
    Button TransbtnBuscar;
    EditText EditNumT;
    //por aqui va shace el servicio y crear el TrandBuscarList
    Transferencium xListTransf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_buscar2);

        TranstxtError=findViewById(R.id.TranstxtError);
        EditNumT=findViewById(R.id.TransferenciaEditNum);

        TransbtnBuscar=findViewById(R.id.TransbtnBuscar);
        TransbtnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                GetFacturasVolley();
            }
        });
    }//Fin OnCreate
    //GetListClass Lista
    //-----------------

    private void GetFacturasVolley()
    {
        Tranfqueue = Volley.newRequestQueue(this);
        String url="http://10.1.201.5/DXInvIT/SapService.svc/xListTransferencia/"+EditNumT.getText(); //Trabajo
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    //---- promero verificar si obtenes el json completo_Verificado

                    Gson gson = new Gson();
                    FindTransfList xListTransferencias = gson.fromJson(response.toString(), FindTransfList.class); //response.toString() o txt
                    //txtError.setText("GetListClassVolley R: "+response.toString());
                    //Log.d("GetListClass response ", response.toString());
                    if(!xListTransferencias.getTransferencia().get(0).getDocNum().isEmpty())
                    {
                        TranstxtError.setText(EditNumT.getText()+" tuvo "+xListTransferencias.getTransferencia().size()+" Resultados ");
                        Log.d("Get x ",xListTransferencias.getTransferencia().get(0).getDocNum());//
                        Intent intent = new Intent(TransBuscar2.this, TransListar.class);
                        intent.putExtra("model",  xListTransferencias);
                        startActivity(intent);
                    }
                    else
                    {
                        Log.d("Get z ",xListTransferencias.getTransferencia().get(0).getDocNum());//
                        TranstxtError.setText("Sin Resultados "+xListTransferencias.getTransferencia().get(0).getDocNum()+" xx");

                    }



                } catch (Exception e) {
                    TranstxtError.setText("e1 "+e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                TranstxtError.setText("E2 "+error.getMessage().toString());
            }
        });
        Tranfqueue.add(request);
    }
    //------------------------------------------------------------------------------------
}
