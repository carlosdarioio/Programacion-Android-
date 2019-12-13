package com.example.navigationdrawact;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.navigationdrawact.JsonClass.Factura;
import com.example.navigationdrawact.JsonClass.FindFacturaList;
import com.example.navigationdrawact.adapter.AdapterListFacturas;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class BuscarFactura extends AppCompatActivity {
    private RequestQueue queueFindFactura;
    TextView txtError;
    Button btnBuscar;
    EditText EditNumFactura;
    private ListView lista;
    private AdapterListFacturas nombresAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_factura);

        txtError=findViewById(R.id.txtError);
        EditNumFactura=findViewById(R.id.EditNumFactura);

        btnBuscar=findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(BuscarFactura.this,"btnbuscar :",Toast.LENGTH_LONG).show();
                GetFacturasVolley();
            }
        });




    }



    //GetListClass Lista
    //-----------------

    private void GetFacturasVolley()
    {
        queueFindFactura = Volley.newRequestQueue(this);
        //String url="http://192.168.0.18/WcfLocal1/Service1.svc/GetListClass"; //Casa
        String url="http://10.1.201.5/DXInvIT/SapService.svc/FindFactura/"+EditNumFactura.getText(); //Trabajo
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    //---- promero verificar si obtenes el json completo_Verificado

                    Gson gson = new Gson();
                    FindFacturaList xListFacturas = gson.fromJson(response.toString(), FindFacturaList.class); //response.toString() o txt
                    //txtError.setText("GetListClassVolley R: "+response.toString());
                    //Log.d("GetListClass response ", response.toString());
                    if(!xListFacturas.getFacturas().get(0).getFACTURA().isEmpty())
                    {
                        txtError.setText("Con Resultados "+xListFacturas.getFacturas().get(0).getFACTURA());
                        Log.d("Get x ",xListFacturas.getFacturas().get(0).getFACTURA());//


                        //======================================
                        //inicializar adapter
                        ArrayList<Factura> model =  (ArrayList)xListFacturas.getFacturas();//(ArrayList<Factura>) getIntent().getSerializableExtra("model");
                        nombresAdapter=new AdapterListFacturas(BuscarFactura.this,model);

                        lista=(ListView)findViewById(R.id.listafacturas);//agregar adaptador en lista
                        lista.setAdapter(nombresAdapter);

                        //mostrando texto seleccionaod por cada clicik que da
                        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Factura mScanLista=(Factura)nombresAdapter.getItem(position);
                                Toast.makeText(getBaseContext(),"Tu Factura es "+mScanLista.getFACTURA(), Toast.LENGTH_LONG).show();
                                //pones sartactivity desde aqui
                                //startActivity(DetallerActivity.getCallingIntent(context,mDetalles));


                            }
                        });//Find lista.setOnItemClickListener
                        //=====================================
                    }
                    else
                    {
                        Log.d("Get z ",xListFacturas.getFacturas().get(0).getFACTURA());//
                        txtError.setText("Sin Resultados "+xListFacturas.getFacturas().get(0).getFACTURA()+" xx");

                    }



                } catch (Exception e) {
                    txtError.setText("e1 "+e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                txtError.setText("E2 "+error.getMessage().toString());
            }
        });
        queueFindFactura.add(request);
    }
    //------------------------------------------------------------------------------------
}
