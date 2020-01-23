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

public class MarcarPorCodigo extends AppCompatActivity {
    private RequestQueue Marcarqueue;
    TextView Macrartxterror;
    Button MarcarBtnMarca;
    EditText MarcarTracve,MarcarAlmacen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_por_codigo);

        Macrartxterror=findViewById(R.id.MarcartxtError);
        MarcarTracve=findViewById(R.id.MarcarTracve);
        MarcarAlmacen=findViewById(R.id.MarcarAlmacen);

        MarcarBtnMarca=findViewById(R.id.MarcarBtnMarcar);

        MarcarBtnMarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(MarcarTracve.getText().toString().length()>3){
                    //por aqui vas  pendiente crear el servicio donde recibira el codigo pa marcar osea
                    String url = "http://10.1.201.5/DXInvIT/SapService.svc/xMarcarPorCodigoAndroid";//trabajo
                    Marcarqueue = Volley.newRequestQueue(MarcarPorCodigo.this);
                    JSONObject jsonRequest = new JSONObject();
                    try
                    {
                        jsonRequest.put("valor",MarcarTracve.getText());
                    }
                    catch (JSONException e)
                    {
                        Toast.makeText(MarcarPorCodigo.this,"zError:",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                    JsonObjectRequest request3 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try
                            {
                                Macrartxterror.setText(" Respuesta : "+response.getString("response"));
                                Log.d("response ", response.toString());
                                MarcarTracve.setText("");
                                //Log.d("response ", response.getString("status")+" 2 "+response.getString("value"));
                            } catch (Exception e) {
                                Macrartxterror.setText("Error ent1");
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            Macrartxterror.setText("PostT Errorb1 "+error.toString());
                        }
                    });
                    Marcarqueue.add(request3);
                    //-------------------------______________________________________
                }else{Macrartxterror.setText(" Rellenar todos los datos ");}

                //--................
            }
        });

    }
}
