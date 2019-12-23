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

public class DesbloquearArticulos extends AppCompatActivity {
    EditText articulo,almacen;
    Button btnDescArt;
    TextView txtresponse;
    private RequestQueue queuexDesbArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desbloquear_articulos);

        articulo=findViewById(R.id.articulo);
        almacen=findViewById(R.id.almacen);
        btnDescArt=findViewById(R.id.btnDescArt);
        txtresponse=findViewById(R.id.response);


        //btn Descuento Manual
        btnDescArt.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                //Factura 1150219857
                                                if(articulo.getText().toString().length()>0 && almacen.getText().toString().length()>0){
                                                    String url = "http://10.1.201.5/DXInvIT/SapService.svc/xDesbloquearArticulo";//trabajo
                                                    //por aqui vas pendiente servicio
                                                    //--------------------------___________________________________
                                                    queuexDesbArt = Volley.newRequestQueue(DesbloquearArticulos.this);
                                                    JSONObject jsonRequest = new JSONObject();
                                                    try
                                                    {
                                                        jsonRequest.put("almacen",almacen.getText());
                                                        jsonRequest.put("articulo",articulo.getText());

                                                    }
                                                    catch (JSONException e)
                                                    {
                                                        Toast.makeText(DesbloquearArticulos.this,"zError:",Toast.LENGTH_LONG).show();
                                                        e.printStackTrace();
                                                    }
                                                    JsonObjectRequest request3 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                                                        @Override
                                                        public void onResponse(JSONObject response)
                                                        {
                                                            try
                                                            {
                                                                txtresponse.setText(" Respuesta : "+response.getString("response"));
                                                                Log.d("response ", response.toString());
                                                                articulo.setText("");
                                                                almacen.setText("");
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
                                                    queuexDesbArt.add(request3);
                                                    //-------------------------______________________________________
                                                }else{txtresponse.setText(" Rellenar todos los datos ");}
                                            }
                                        }
        );//fin Dar Descuento Manual

    }//fin oncreate


//fin public calss
}
