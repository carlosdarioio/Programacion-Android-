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
import com.example.navigationdrawact.JsonClass.FindClList;
import com.google.gson.Gson;

import org.json.JSONObject;

public class ClBuscar extends AppCompatActivity {
    private RequestQueue queueFindCL;
    TextView txtError;
    Button btnBuscar;
    EditText EditCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl_buscar);

        txtError=findViewById(R.id.txtErrorclb);
        EditCliente=findViewById(R.id.clEditCliente);

        btnBuscar=findViewById(R.id.btnBuscarcl);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                GetClienteContactInfoVolley();
            }
        });
    }//Fin Oncreate

    //GetListClass Lista
    //-----------------

    private void GetClienteContactInfoVolley()
    {
        queueFindCL = Volley.newRequestQueue(this);
        String url="http://10.1.201.5/DXInvIT/SapService.svc/GetClienteContactInfo/"+EditCliente.getText().toString(); //Trabajo
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    Gson gson = new Gson();
                    FindClList xListCL = gson.fromJson(response.toString(), FindClList.class); //response.toString() o txt
                    if(!xListCL.getCLContacInfo().get(0).getNombre().isEmpty())
                    {
                        txtError.setText(EditCliente.getText()+" tuvo "+xListCL.getCLContacInfo().size()+" Resultados ");
                        Log.d("Get x ",xListCL.getCLContacInfo().get(0).getCodigo());//
                        Intent intent = new Intent(ClBuscar.this, ClListar.class);
                        intent.putExtra("model",  xListCL);
                        startActivity(intent);
                    }
                    else
                    {
                        Log.d("Get z ",xListCL.getCLContacInfo().get(0).getNombre());//
                        txtError.setText("Sin Resultados "+xListCL.getCLContacInfo().get(0).getNombre()+" xx");

                    }



                } catch (Exception e) {
                    txtError.setText("ecl1 "+e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                txtError.setText("Ecl2 "+error.getMessage().toString());
            }
        });
        queueFindCL.add(request);
    }
    //------------------------------------------------------------------------------------
}//Fin CLBuscar
