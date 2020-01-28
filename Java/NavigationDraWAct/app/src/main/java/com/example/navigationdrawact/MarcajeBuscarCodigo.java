package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.navigationdrawact.JsonClass.Marcaje;
import com.example.navigationdrawact.JsonClass.MarcajeBuscarCodigoClase1;
import com.example.navigationdrawact.adapter.MarcajeXCodigoApapter;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MarcajeBuscarCodigo extends AppCompatActivity {

    private RequestQueue mcbqueue;
    TextView mcbtxtError;
    Button mcbbtnBuscar;
    EditText mcbCodigo;
    private ListView lista;
    private MarcajeXCodigoApapter MarcajeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcaje_buscar_codigo);

        mcbtxtError=findViewById(R.id.mcbtxtError);
        mcbCodigo=findViewById(R.id.mcbCodigo);

        lista=(ListView)findViewById(R.id.mcblista);//agregar adaptador en lista


        mcbbtnBuscar=findViewById(R.id.mcbbtnBuscar);
        mcbbtnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                    //curiosidades seguis trabajando en el formato de if
                    //pasate el de return pa no depender de meterte dentro y dentro de if
                //_______________________________________________________________________
                if(mcbCodigo.getText().toString().length()>3){
                    String url = "http://10.1.201.5/DXInvIT/SapService.svc/FindMarcarjeXCodigoAndroid";//trabajo
                    mcbqueue = Volley.newRequestQueue(MarcajeBuscarCodigo.this);
                    JSONObject jsonRequest = new JSONObject();
                    try
                    {
                        jsonRequest.put("valor",mcbCodigo.getText());
                    }
                    catch (JSONException e)
                    {
                        Toast.makeText(MarcajeBuscarCodigo.this,"zError:",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                    JsonObjectRequest request3 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try
                            {
                                mcbtxtError.setText(" Respuesta : "+response.getString("status"));
                                Log.d("response ", response.toString());

                                Gson gson = new Gson();
                                MarcajeBuscarCodigoClase1 xListMarcaje = gson.fromJson(response.toString(), MarcajeBuscarCodigoClase1.class); //response.toString() o txt
                                if(!xListMarcaje.getMarcajes().get(0).getCONSEC().isEmpty())
                                {
                                    mcbtxtError.setText(mcbCodigo.getText()+" tuvo "+xListMarcaje.getMarcajes().size()+" Resultados ");
                                    Log.d("Get x ",xListMarcaje.getMarcajes().get(0).getHORAMA());//

        //--por aqui vas pendiente meter La Lista al AdapterListCl
       //-------------------------------------------
        ArrayList<Marcaje> model = (ArrayList<Marcaje>) xListMarcaje.getMarcajes();
        MarcajeAdapter=new MarcajeXCodigoApapter(MarcajeBuscarCodigo.this,model);
        lista.setAdapter(MarcajeAdapter);
       //------------------------------------------
                                }
                                else
                                {
                                    Log.d("Get z ",xListMarcaje.getMarcajes().get(0).getLOCAL());//
                                    mcbtxtError.setText("Sin Resultados "+xListMarcaje.getMarcajes().get(0).getTRACVE()+" xx");
                                }
                            } catch (Exception e) {
                                mcbtxtError.setText("Error Marca1 "+e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            mcbtxtError.setText("PostT EMarcar2 "+error.toString());
                        }
                    });
                    mcbqueue.add(request3);
                    //-------------------------______________________________________
                }else{mcbtxtError.setText(" Rellenar todos los datos ");}
                //_______________________________________________________________________
            }
        });
    }//Fin Oncreate


}
