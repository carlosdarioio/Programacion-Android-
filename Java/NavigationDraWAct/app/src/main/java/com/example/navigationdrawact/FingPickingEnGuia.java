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

public class FingPickingEnGuia extends AppCompatActivity {

    private RequestQueue queuePrintTransG;
    TextView FPENtxtError;
    Button btnFindPicking;
    EditText Picking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fing_picking_en_guia);

        FPENtxtError=findViewById(R.id.FPENtxtError);
        Picking=findViewById(R.id.Picking);

        btnFindPicking=findViewById(R.id.btnFindPicking);
        btnFindPicking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                //--...............
                //Factura 1150219857
                if(Picking.getText().toString().length()>4){
                    String url = "http://10.1.201.5/DXInvIT/SapService.svc/SeguimientoDePickingEnGuia";//trabajo
                    //--------------------------___________________________________
                    queuePrintTransG = Volley.newRequestQueue(FingPickingEnGuia.this);
                    JSONObject jsonRequest = new JSONObject();
                    try
                    {
                        jsonRequest.put("valor",Picking.getText());
                    }
                    catch (JSONException e)
                    {
                        Toast.makeText(FingPickingEnGuia.this,"zError:",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                    JsonObjectRequest request3 = new JsonObjectRequest(Request.Method.POST, url, jsonRequest, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try
                            {
                                FPENtxtError.setText(" Respuesta : "+response.getString("response"));
                                Log.d(" response ", response.toString());
                                Picking.setText("");
                            } catch (Exception e) {
                                FPENtxtError.setText(" Error ent1 ");
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            FPENtxtError.setText(" PostT Errorb1 "+error.toString());
                        }
                    });
                    queuePrintTransG.add(request3);
                    //-------------------------______________________________________
                }else{FPENtxtError.setText(" Rellenar todos los datos ");}

                //--................
            }
        });
    }
}
