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
import com.example.navigationdrawact.JsonClass.CLContacInfo;

import org.json.JSONException;
import org.json.JSONObject;


public class CLver extends AppCompatActivity {
    TextView txtErrorart,xcl,cltel1,cltel2,clcel;
    CLContacInfo model;
    private RequestQueue queuexCL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clver);

        txtErrorart=findViewById(R.id.txtError);
        model = (CLContacInfo) getIntent().getSerializableExtra("model");
        Log.d("model",model.getNombre());


        xcl=findViewById(R.id.cl);
        cltel1=findViewById(R.id.cltel1);
        cltel2=findViewById(R.id.cltel2);
        clcel=findViewById(R.id.clcel);

        xcl.setText("Cliente: "+ model.getCodigo()+" "+model.getNombre());
        cltel1.setText("Telefono1: "+ model.getPhone1());
        cltel2.setText("Telefono2: "+ model.getPhone2());
        clcel.setText("Celular: "+ model.getCelular());

        //por aqui vas

        //crear la opcion para bloquear, desbloquear
        //pasa los datos a un edic text para que se pueda editar
        //añadile el rtn
        //añadir boton para actualizar nombre/rtn de cliente
        Button clbtnblckUn;
        clbtnblckUn=findViewById(R.id.clbtnblckUn);
        clbtnblckUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //Toast.makeText(getBaseContext()," Proximamente "+model.getCodigo(),Toast.LENGTH_LONG).show();

              //zzzzzzzzzzzzz
              String url = "http://10.1.201.5/DXInvIT/SapService.svc/FrozenXValidClient";//trabajo
                    //por aqui vas pendiente servicio
                    //--------------------------___________________________________
                queuexCL = Volley.newRequestQueue(CLver.this);
                    JSONObject jsonRequest = new JSONObject();
                    try
                    {
                        jsonRequest.put("cardcode",model.getCodigo());

                    }
                    catch (JSONException e)
                    {
                        Toast.makeText(CLver.this,"ClError:",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                    JsonObjectRequest request3 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try
                            {
                                txtErrorart.setText(" Respuesta : "+response.getString("response"));
                                Log.d("response ", response.toString());
                            } catch (Exception e) {
                                txtErrorart.setText("Error cl1");
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            txtErrorart.setText("PostT Errorcl "+error.toString());
                        }
                    });
                queuexCL.add(request3);
                    //-------------------------______________________________________

                //zzzzzzzzzzzzzzz
            }
        });

    }
}
